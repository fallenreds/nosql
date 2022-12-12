package domain.entity.workout

import java.util.Date

data class Workout(
    val id: Long,
    val type: String,
    val date: Date,
    val clientId: Int,
    var exercises: List<Exercise>? = null,
)