package com.se7en.fearngreed.ui.index

import com.se7en.fearngreed.data.repository.FGIndexRepository
import com.se7en.fearngreed.data.repository.Resource
import com.se7en.fearngreed.model.FGIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AllIndexesViewModel @Inject constructor(
    private val repository: FGIndexRepository
) : IndexViewModel<List<FGIndex>>() {

    init {
        println("initializing all view model")
    }

    override fun fetchData(): Flow<Resource<List<FGIndex>>> = repository.getAllIndexes()
}
