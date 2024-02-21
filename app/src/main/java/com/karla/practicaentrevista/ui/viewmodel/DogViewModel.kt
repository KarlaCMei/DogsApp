package com.karla.practicaentrevista.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karla.practicaentrevista.domain.GetDogsUseCase
import kotlinx.coroutines.launch

class DogViewModel:  ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    private val dogIma = MutableLiveData<List<String>>()
    val dogImages: LiveData<List<String>> get() = dogIma

    private val getQuotesUseCase = GetDogsUseCase()

    fun searchDogsByBreed(query: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = getQuotesUseCase.execute(query)
            dogIma.value = (response?.images ?: emptyList())
            isLoading.postValue(false)
        }
    }

}