package com.se7en.fearngreed.ui.index

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.se7en.fearngreed.data.repository.Resource
import kotlinx.coroutines.flow.*

abstract class IndexViewModel<T> : ViewModel() {

    val uiState: StateFlow<IndexUIState<T>> by lazy {
        fetchData().map { it.toIndexUIState() }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            initialValue = IndexUIState.Idle
        )

    }

    protected abstract fun fetchData(): Flow<Resource<T>>
}

fun <T> Resource<T>.toIndexUIState() = when (this) {
    Resource.Loading -> IndexUIState.Loading
    is Resource.Success -> IndexUIState.Success(data = data)
    is Resource.Error -> IndexUIState.Error(message = message)
}
