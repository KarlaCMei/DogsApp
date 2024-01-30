package com.karla.practicaentrevista

import com.google.gson.annotations.SerializedName

data class  DogResponse(
    @SerializedName("message")val images: List<String>,
    @SerializedName("status")val status: String
)