package com.se7en.fearngreed.di

import com.se7en.fearngreed.data.remote.api.FGIndexApi
import com.se7en.fearngreed.data.repository.DefaultFGIndexRepository
import com.se7en.fearngreed.data.repository.FGIndexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideFGIndexRepository(
        api: FGIndexApi
    ): FGIndexRepository {
        return DefaultFGIndexRepository(api)
    }
}
