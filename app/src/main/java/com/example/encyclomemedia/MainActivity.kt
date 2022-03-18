package com.example.encyclomemedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import coil.load
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        var imageView : ImageView = findViewById(R.id.imageView)

        model.Data.observe(this) {meme ->
            imageView.load(meme.url)
        }

        button.setOnClickListener{
            model.setVal(Random.nextInt(100))
        }
    }
}