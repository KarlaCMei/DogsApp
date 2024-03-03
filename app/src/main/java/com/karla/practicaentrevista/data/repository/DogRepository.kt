package com.karla.practicaentrevista.data.repository

import com.karla.practicaentrevista.data.model.DogResponse
import com.karla.practicaentrevista.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(private val api : DogService, private val dogProvider: DogProvider){

    suspend fun getDogsByBreed(query: String): DogResponse? {
        val response = api.getQuote(query)
        dogProvider.quote = response
        return response
    }


}