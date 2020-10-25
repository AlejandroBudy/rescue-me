package com.alejandrobudy.es.rescueme.application.service

import com.alejandrobudy.es.rescueme.application.ports.inbound.DogRegistration
import com.alejandrobudy.es.rescueme.domain.Dog
import org.springframework.stereotype.Service

@Service
class DogRegistrationService : DogRegistration {

    override fun registerDog(dog: Dog) {
        println("dog with name ${dog.name} and ${dog.breed} breed is saved!")
        throw RuntimeException("Error forced")
    }

}