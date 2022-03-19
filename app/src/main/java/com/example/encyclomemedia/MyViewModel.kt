package com.example.encyclomemedia

import androidx.lifecycle.*

// Classe ViewModel pour stocker et gérer les données liées à l'UI en tenant compte du cycle de vie
// Classe permettant aux données de survivre aux changements de configuration tels que les rotations d'écran
// Chargement des données grâce aux loaders dans cette classe
class MyViewModel : ViewModel(){

    private val loader = Loader()

    val listData: LiveData<List<Meme>> = liveData {
        val memes: List<Meme> = loader.getResponse().data.memes
        emit(memes)
    }
}