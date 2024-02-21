package com.karla.practicaentrevista.data.network

import com.karla.practicaentrevista.core.RetrofitHelper
import com.karla.practicaentrevista.data.model.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuote(query: String): DogResponse?  {
        return withContext(Dispatchers.IO) {
            val call = retrofit.create(ApiService::class.java).getDogsByBreeds("$query/images")
            call.body()

        }
    }

}