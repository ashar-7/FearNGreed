package com.se7en.fearngreed.model

data class FGIndex(
    val timeUntilUpdate: String?,
    val timestamp: Long,
    val value: Int,
    val classification: String
)

fun List<FGIndexData>.toFGIndexList(): List<FGIndex> = map { it.toFGIndex() }

fun FGIndexData.toFGIndex() =
    FGIndex(
        timeUntilUpdate = timeUntilUpdate,
        timestamp = timestamp.toLong(),
        value = value,
        classification = valueClassification ?: when {
            value < 25 -> "Extreme Fear"
            value < 50 -> "Fear"
            value < 75 -> "Greed"
            value <= 100 -> "Extreme Greed"
            else -> "Invalid"
        }
    )
