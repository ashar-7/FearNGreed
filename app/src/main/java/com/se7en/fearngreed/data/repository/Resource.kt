package com.se7en.fearngreed.data.repository

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    class Success<out T>(val data: T) : Resource<T>()
    class Failed(val message: String) : Resource<Nothing>()
}
