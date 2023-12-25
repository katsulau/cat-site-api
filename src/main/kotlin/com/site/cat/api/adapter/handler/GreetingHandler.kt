package com.site.cat.api.adapter.handler
import com.site.cat.api.model.Greeting
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono;

@Component
class GreetingHandler {

    fun hello(
        serverRequest: ServerRequest
    ): Mono<ServerResponse> {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(Greeting("hello, world!", "English")))
    }
}