package com.example.encyclomemedia

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

// Classe pour charger les données du fichier JSON en ligne
class Loader {

    // Création d'un client HTTP asynchrone multiplateforme, qui va nous permettre de faire des demandes, de gérer les réponses et de sérialiser des fichiers JSON
    private val client: HttpClient = HttpClient(CIO) {
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                // Pour ignorer les données qui ne nous intéresse pas dans le fichier JSON
                ignoreUnknownKeys = true
            })
        }
    }

    // Fonction pour demander le fichier JSON en ligne
    // Utilisation du mot clé suspend car la réponse peut prendre du temps à arriver
    suspend fun getResponse() : Response {
        return client.get("https://api.imgflip.com/get_memes")
    }
}