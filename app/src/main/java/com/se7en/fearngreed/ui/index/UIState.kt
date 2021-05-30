package com.se7en.fearngreed.ui.index

sealed class IndexUIState<out T> {

    object Idle : IndexUIState<Nothing>()
    object Loading : IndexUIState<Nothing>()
    class Success<out T>(data: T) : IndexUIState<T>()
    class Error(message: String) : IndexUIState<Nothing>()
}
