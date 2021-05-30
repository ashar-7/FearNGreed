package com.se7en.fearngreed.data.remote.api

import com.se7en.fearngreed.model.FGIndexResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FGIndexApi {

    @GET("/fng")
    suspend fun getIndexes(
        @Query("limit") limit: Int,
        @Query("date_format") dateFormat: String
    ): Response<FGIndexResponse>

    companion object {
        const val BASE_URL = "https://api.alternative.me"
    }
}
