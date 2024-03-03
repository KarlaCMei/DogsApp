package com.karla.practicaentrevista.data.network

import com.karla.practicaentrevista.data.model.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val api: ApiService){
    suspend fun getQuote(query: String): DogResponse?  {
        return withContext(Dispatchers.IO) {
            val call = api.getDogsByBreeds("$query/images")
            call.body()

        }
    }

}