package com.alejandrobudy.es.rescueme.application.ports.inbound

import com.alejandrobudy.es.rescueme.domain.Dog

interface DogRegistration {

    fun registerDog(dog: Dog)
}