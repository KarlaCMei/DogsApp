package com.karla.practicaentrevista.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karla.practicaentrevista.data.model.DogProvider
import com.karla.practicaentrevista.data.model.DogResponse
import com.karla.practicaentrevista.domain.GetDogsUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    val dogModel = MutableLiveData<DogResponse?>()
    var getDogsUseCase = GetDogsUseCase()
    fun onCreate(query: String):Boolean {
        viewModelScope.launch{
            val result = getDogsUseCase(query)
            if(!query.isNullOrEmpty()){
                dogModel.postValue(result)
                //searchByName(query.toLowerCase())
            }
        }
        return true
    }
    fun randomDog(){
        /*val currentDog: DogResponse = DogProvider.random()
        dogModel.postValue(currentDog)*/
    }


}