package domain.entity.users

data class RequestDB(
        val id: Int,
        val trainerId: Int,
        val clientId: Int,
        val status: RequestStatus = RequestStatus.UNCHECKED,
)