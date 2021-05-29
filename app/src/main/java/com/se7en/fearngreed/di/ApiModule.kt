package com.se7en.fearngreed.di

import com.se7en.fearngreed.data.remote.api.FGIndexApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    fun provideFGIndexApi(): FGIndexApi {
        return Retrofit.Builder()
            .baseUrl(FGIndexApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(FGIndexApi::class.java)
    }
}
