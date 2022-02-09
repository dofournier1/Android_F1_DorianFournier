package com.example.encyclomemedia

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class Loader {
    private val client: HttpClient = HttpClient(CIO) {
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getResponse() : Response {
        return client.get("https://api.imgflip.com/get_memes")
    }
}