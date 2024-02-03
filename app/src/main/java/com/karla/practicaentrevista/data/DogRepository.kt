package com.karla.practicaentrevista.data

import com.karla.practicaentrevista.data.model.DogProvider
import com.karla.practicaentrevista.data.model.DogResponse
import com.karla.practicaentrevista.data.network.DogService

class DogRepository {

    private val api = DogService()

    suspend fun getAllDogs(dogName: String): DogResponse?{
        val response = api.getDogs(dogName)
        if (response != null) {
            DogProvider.dogs = response
        }
        return response
    }
}