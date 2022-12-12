package domain.entity.users

data class Request(
        val id: Int,
        val trainer: User,
        val client: User,
        val status: RequestStatus = RequestStatus.UNCHECKED,
)