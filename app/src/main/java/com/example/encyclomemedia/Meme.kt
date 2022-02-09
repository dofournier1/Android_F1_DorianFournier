package com.example.encyclomemedia

import kotlinx.serialization.*

@Serializable
data class Response(val data: Memes){}

@Serializable
data class Memes(val memes: List<Meme>){}

@Serializable
data class Meme (val id: Int, val name: String, val url: String, val width: Int, val height: Int, val box_count: Int){}