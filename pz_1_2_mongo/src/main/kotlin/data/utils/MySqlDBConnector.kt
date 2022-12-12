package data.utils

import java.sql.Connection
import java.sql.DriverManager
import java.util.*

class MySqlDBConnector : DBConnector {

    private val properties =  Properties()

    init {
        properties.load(javaClass.classLoader.getResourceAsStream("application.properties"))
    }

    override fun getConnection(): Connection {

        val user = properties.getProperty("db.mysql.username")
        val password = properties.getProperty("db.mysql.password")
        val url = properties.getProperty("db.mysql.url")



        return DriverManager.getConnection(url, user, password)
    }
}