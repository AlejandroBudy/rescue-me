package com.alejandrobudy.es.rescueme.presentation

import com.alejandrobudy.es.rescueme.application.ports.inbound.DogRegistration
import com.alejandrobudy.es.rescueme.presentation.model.DogPayload
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class DogRegisterHandler(val dogRegistration: DogRegistration) {

    fun register(serverRequest: ServerRequest) =
            serverRequest.bodyToMono(DogPayload::class.java)
                    .map { t: DogPayload? -> DogPayload.toDomain(t!!) }
                    .map { dogRegistration.registerDog(it) }
                    .flatMap { ok().build() }
                    .onErrorResume { t: Throwable? ->
                        println("Error occurred ${t?.message}")
                        ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                    }


    fun list(serverRequest: ServerRequest) = ok().build()
}