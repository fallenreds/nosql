import data.dao.impl.mysql.*
import data.utils.DBConnector
import data.utils.MySqlDBConnector
import domain.entity.users.RequestDB
import domain.entity.users.RequestStatus
import domain.entity.users.User
import domain.entity.workout.CompletedSet
import domain.entity.workout.Exercise
import domain.entity.workout.Time
import domain.entity.workout.Workout
import java.util.*

private val CONNECTOR: DBConnector = MySqlDBConnector()

suspend fun main() {

    val clientsDao = MySqlClientsDaoImpl(CONNECTOR)
    val trainersDao = MySqlTrainersDaoImpl(CONNECTOR)
    val requestsDao = MySqlRequestsDaoImpl(CONNECTOR)
    val workoutsDao = MySqlWorkoutsDaoImpl(CONNECTOR)
    val exercisesDao = MySqlExercisesDaoImpl(CONNECTOR)
    val completedSetsDao = MySqlCompletedSetsDaoImpl(CONNECTOR)


    trainersDao.run {
        create(User(
            id = 0,
            name = "name1",
            surname = "surname1",
            login = "login1",
            password = "12345678",
            phoneNumber = "0996661313",
            email = "email1"
        ))
        println(getById(1))
        update(User(
            id = 1,
            name = "name1",
            surname = "surname1",
            login = "login1",
            password = "87654321",
            phoneNumber = "0996661313",
            email = "email1"
        ))
        println(getById(1))
        println(getNumberOfClients(1))
    }

    clientsDao.run {
        create(User(
            id = 0,
            name = "name2",
            surname = "surname2",
            login = "login2",
            password = "12345678",
            phoneNumber = "0996661313",
            email = "email2"
        ))
        println(getById(1))
        update(User(
            id = 1,
            name = "name2",
            surname = "surname2",
            login = "login2",
            password = "87654321",
            phoneNumber = "0996661313",
            email = "email2"
        ))
        println(getById(1))
    }

    requestsDao.run {
        create(RequestDB(
            id = 0,
            trainerId = 1,
            clientId = 1
        ))
        println(getByClientId(1))
        println(getByTrainerId(1))
        update(RequestDB(
            id = 1,
            trainerId = 1,
            clientId = 1,
            status = RequestStatus.CONFIRMED
        ))
        println(getByClientId(1))
        println(getByTrainerId(1))
    }
    println(trainersDao.getNumberOfClients(1))

    workoutsDao.run {
        create(Workout(
            id = 0,
            type = "workout1",
            date = Date(),
            clientId = 1
        ))
        println(getByClientId(1, 0, 1))
        update(Workout(
            id = 1,
            type = "workout2",
            date = Date(),
            clientId = 1
        ))
        println(getByClientId(1, 0, 1))
    }

    exercisesDao.run {
        create(Exercise(
            id = 0,
            name = "exercise1",
            weightFrom = 10,
            weightTo = 15,
            repetitionsFrom = 14,
            repetitionsTo = 16,
            sets = 3,
            time = Time(0, 45),
            workoutId = 1
        ))
        println(getByWorkoutId(1))
        update(Exercise(
            id = 1,
            name = "exercise2",
            weightFrom = 10,
            weightTo = 15,
            repetitionsFrom = 14,
            repetitionsTo = 16,
            sets = 3,
            time = Time(0, 45),
            workoutId = 1
        ))
        println(getByWorkoutId(1))
    }

    completedSetsDao.run {
        create(CompletedSet(
            id = 0,
            setNumber = 1,
            repetitions = 16,
            weight = 16,
            time = Time(0, 42),
            exerciseId = 1
        ))
        println(getByExerciseId(1))
        update(CompletedSet(
            id = 1,
            setNumber = 2,
            repetitions = 16,
            weight = 16,
            time = Time(0, 42),
            exerciseId = 1
        ))
        println(getByExerciseId(1))
    }

    trainersDao.delete(User(
        id = 1,
        name = "name1",
        surname = "surname1",
        login = "login1",
        password = "87654321",
        phoneNumber = "0996661313",
        email = "email1"
    ))
    println(trainersDao.getById(1))
    println(clientsDao.getById(1))
    println(workoutsDao.getByClientId(1, 0, 1))
    println(exercisesDao.getByWorkoutId(1))
    println(completedSetsDao.getByExerciseId(1))
    clientsDao.delete(User(
        id = 1,
        name = "name2",
        surname = "surname2",
        login = "login2",
        password = "87654321",
        phoneNumber = "0996661313",
        email = "email2"
    ))
    println(clientsDao.getById(1))
    println(workoutsDao.getByClientId(1, 0, 1))
    println(exercisesDao.getByWorkoutId(1))
    println(completedSetsDao.getByExerciseId(1))
}