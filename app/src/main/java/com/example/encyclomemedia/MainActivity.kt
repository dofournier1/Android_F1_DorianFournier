package com.example.encyclomemedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import coil.load
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels()
    private var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        var imageView : ImageView = findViewById(R.id.imageView)

        button.setOnClickListener{
            model.setVal(i)
            i++
            model.Data.observe(this) {meme ->
                imageView.load(meme.url)
            }
        }
    }
}