package domain.entity.workout

data class CompletedSet(
        val id: Long,
        val setNumber: Byte,
        val repetitions: Short,
        val weight: Short?,
        val time: Time?,
        val notes: String? = null,
        val exerciseId: Long,
)