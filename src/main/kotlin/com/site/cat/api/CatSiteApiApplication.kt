package com.site.cat.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatSiteApiApplication

fun main(args: Array<String>) {
    runApplication<CatSiteApiApplication>(*args)
}
