package com.karla.practicaentrevista.data.network

import com.karla.practicaentrevista.core.RetrofitHelper
import com.karla.practicaentrevista.data.model.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val dogImages = mutableListOf<String>()

    //cambiar funcion si no funciona.
    suspend fun getDogs(query: String): DogResponse? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getDogsByBreeds("$query/images")
            response.body()
        }
    }

    /*suspend fun searchByName(
        query: String,
        onSuccess: (List<String>) -> Unit,
        onFailure: () -> Unit
    ) {
        MainScope().launch(Dispatchers.IO) {
            try {
                val call = retrofit.create(ApiService::class.java).getDogsByBreeds("$query/images")
                val puppies = call.body()

                launch(Dispatchers.Main) {
                    if (call.isSuccessful) {
                        val images: List<String> = puppies?.images ?: emptyList()
                        onSuccess(images)
                    } else {
                        onFailure()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                onFailure()
            }
        }

    }*/
}

