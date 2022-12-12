package domain.entity.workout

data class Exercise(
    val id: Long,
    val name: String,
    val sets: Byte,
    val repetitionsFrom: Short,
    val repetitionsTo: Short,
    val weightFrom: Short?,
    val weightTo: Short?,
    val time: Time?,
    val notes: String? = null,
    var completedSets: List<CompletedSet>? = null,
    val workoutId: Long,
)