package com.karla.practicaentrevista.domain

import com.karla.practicaentrevista.data.model.DogResponse
import com.karla.practicaentrevista.data.repository.DogRepository
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val repository : DogRepository){

    suspend fun execute(query: String): DogResponse? {
        return repository.getDogsByBreed(query)
    }

}