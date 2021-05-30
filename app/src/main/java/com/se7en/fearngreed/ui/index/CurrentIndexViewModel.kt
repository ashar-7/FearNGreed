package com.se7en.fearngreed.ui.index

import com.se7en.fearngreed.data.repository.FGIndexRepository
import com.se7en.fearngreed.data.repository.Resource
import com.se7en.fearngreed.model.FGIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CurrentIndexViewModel @Inject constructor(
    private val repository: FGIndexRepository
) : IndexViewModel<FGIndex>() {

    override fun fetchData(): Flow<Resource<FGIndex>> = repository.getLatestIndex()
}
