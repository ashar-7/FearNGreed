package com.se7en.fearngreed.viewmodel

import androidx.lifecycle.ViewModel
import com.se7en.fearngreed.data.repository.FGIndexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FearNGreedViewModel @Inject constructor(
    private val repository: FGIndexRepository
) : ViewModel() {

}
