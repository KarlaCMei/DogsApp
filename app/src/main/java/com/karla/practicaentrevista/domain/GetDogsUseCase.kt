package com.karla.practicaentrevista.domain

import com.karla.practicaentrevista.data.DogRepository
import com.karla.practicaentrevista.data.model.DogResponse

class GetDogsUseCase {
    private val dogRepository = DogRepository()

    suspend operator fun invoke(dogName: String):DogResponse? = dogRepository.getAllDogs(dogName)

}