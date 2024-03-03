package com.karla.practicaentrevista.data.repository

import com.karla.practicaentrevista.data.model.DogResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogProvider @Inject constructor(){
        var quote: DogResponse? = null

}