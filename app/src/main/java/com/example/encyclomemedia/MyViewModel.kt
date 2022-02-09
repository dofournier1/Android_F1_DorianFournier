package com.example.encyclomemedia

import androidx.lifecycle.*

class MyViewModel : ViewModel(){

    private val loader = Loader()
    private var _ind =  MutableLiveData<Int>(0)

    val listData: LiveData<List<Meme>> = liveData {
        val memes: List<Meme> = loader.getResponse().data.memes
        emit(memes)
    }

    var Data: LiveData<Meme> = listData.switchMap { list ->
        _ind.map { list to it }
    }.map {
        (list, index) ->
        list[index]
    }

    fun setVal(ind: Int) {
        _ind.value = ind
    }
}