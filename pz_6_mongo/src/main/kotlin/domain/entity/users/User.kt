package domain.entity.users

data class User(
        val id: Int,
        val name: String,
        val surname: String,
        val login: String,
        val password: String?,
        val phoneNumber: String?,
        val email: String,
)