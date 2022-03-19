package com.example.encyclomemedia

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load

// Classe de l'activité qui affichera les détail des éléments de la recyclerView
class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_activity)

        // Récupération des informations envoyé lors de la création de l'activité
        val name = intent.getStringExtra("EXTRA_NAME")
        val details = intent.getStringExtra("EXTRA_DETAILS")
        val url = intent.getStringExtra("EXTRA_URL")

        val textViewName: TextView = findViewById(R.id.textViewNameInformation)
        val textViewDetail: TextView = findViewById(R.id.textViewDetailsInformation)
        val imageViewMeme: ImageView = findViewById(R.id.imageViewMemeInformation)

        textViewName.text = name
        textViewDetail.text = details
        imageViewMeme.load(url)
    }
}