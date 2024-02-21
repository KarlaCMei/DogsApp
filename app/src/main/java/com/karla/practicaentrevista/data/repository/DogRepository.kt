package com.karla.practicaentrevista.data.repository

import com.karla.practicaentrevista.data.model.DogResponse
import com.karla.practicaentrevista.data.network.DogService

class DogRepository {
    private val api = DogService()

    suspend fun getDogsByBreed(query: String): DogResponse? {
        val response = api.getQuote(query)
        DogProvider.quote = response
        return response
    }


}