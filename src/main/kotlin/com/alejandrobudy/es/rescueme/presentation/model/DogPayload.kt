package com.alejandrobudy.es.rescueme.presentation.model

import com.alejandrobudy.es.rescueme.domain.Dog

data class DogPayload(val name: String, val breed: String) {

    companion object {
        fun toDomain(dogPayload: DogPayload) = Dog(dogPayload.name, dogPayload.breed)
    }
}