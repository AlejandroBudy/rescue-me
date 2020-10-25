package com.alejandrobudy.es.rescueme.presentation

import lombok.extern.log4j.Log4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Log4j
@Configuration
class Routes(val dogRegisterHandler: DogRegisterHandler) {

    @Bean
    fun router() = router {
        "/dogs".nest {
            accept(APPLICATION_JSON).nest {
                POST("/", dogRegisterHandler::register)
                GET("/", dogRegisterHandler::list)
            }
        }
        "/shelter".nest {
            POST("/") {
                ServerResponse
                        .ok()
                        .body(BodyInserters.fromValue("hello world"))
            }
        }

    }
}