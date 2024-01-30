package com.karla.practicaentrevista

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    /*URL DE LA API
    https://dog.ceo/api/breed/hound/images */

    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogResponse>
}