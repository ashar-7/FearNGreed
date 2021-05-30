package com.se7en.fearngreed.data.repository

import com.se7en.fearngreed.data.remote.api.FGIndexApi
import com.se7en.fearngreed.model.FGIndex
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface FGIndexRepository {

    fun getLatestIndex(): Flow<Resource<FGIndex>>
    fun getAllIndexes(): Flow<Resource<List<FGIndex>>>
}

class DefaultFGIndexRepository @Inject constructor(
    private val api: FGIndexApi
) : FGIndexRepository {

    override fun getLatestIndex(): Flow<Resource<FGIndex>> = flow {
        emit(Resource.Loading)
        when (val resource = getIndexes(limit = 1)) {
            is Resource.Success -> {
                emit(Resource.Success(resource.data[0]))
            }
            is Resource.Error -> {
                emit(Resource.Error(resource.message))
            }
        }
    }

    override fun getAllIndexes(): Flow<Resource<List<FGIndex>>> = flow {
        emit(Resource.Loading)
        val resource = getIndexes(limit = 0)
        emit(resource)
    }

    private suspend fun getIndexes(
        limit: Int,
        dateFormat: String = ""
    ): Resource<List<FGIndex>> {
        val response = api.getIndexes(limit, dateFormat)
        val indexes = response.body()
        return if (response.isSuccessful && indexes != null && indexes.data.isNotEmpty()) {
            Resource.Success(indexes.data)
        } else Resource.Error(indexes?.metadata?.error ?: "Unknown error")
    }
}
