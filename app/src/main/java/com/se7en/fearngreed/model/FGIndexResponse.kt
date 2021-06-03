package com.se7en.fearngreed.model

import com.squareup.moshi.Json

data class FGIndexResponse(
    @Json(name = "data") val `data`: List<FGIndexData>,
    @Json(name = "metadata") val metadata: Metadata,
    @Json(name = "name") val name: String
)

data class FGIndexData(
    @Json(name = "time_until_update") val timeUntilUpdate: String?,
    @Json(name = "timestamp") val timestamp: String,
    @Json(name = "value") val value: Int,
    @Json(name = "value_classification") val valueClassification: String?
)

data class Metadata(
    @Json(name = "error") val error: String?
)
