package com.site.cat.api.adapter.router

import com.site.cat.api.adapter.handler.GreetingHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class SampleRouter {

    // sample code e.g https://spring.io/guides/gs/reactive-rest-service/
    @Bean
    fun route(
        greetingHandler: GreetingHandler
    ): RouterFunction<ServerResponse> {
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
    }
}