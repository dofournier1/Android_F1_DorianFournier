package com.example.encyclomemedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

// Classe de l'activité principale du projet (Titre + recyclerView)
class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels()

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val relativeLayout: LinearLayout = findViewById(R.id.mainLayout)

        // Initialisation du recyclerView et définition de l'Adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        model.listData.observe(this) { memes ->
            recyclerView.adapter = Adapter(memes){ name -> clickListener(name) }
        }

        // Définition d'une coroutine qui change la couleur du background de l'activité toutes les x secondes
        GlobalScope.launch(Dispatchers.IO) {
            while(true) {
                delay(TimeUnit.SECONDS.toMillis(Random.nextLong(5)))
                withContext(Dispatchers.Main) {
                    when (Random.nextBoolean()) {
                        true -> relativeLayout.setBackgroundResource(R.color.invert_zinzolin)
                        false -> relativeLayout.setBackgroundResource(R.color.zinzolin)
                    }
                }
            }
        }
    }

    // Définition de la fonction à appeler lorsque l'utilisateur clique sur un élément de la recyclerView
    // Création d'une activité secondaire qui va afficher les détails de l'élément de la recyclerView cliqué
    private fun clickListener(data: Meme) {
        val intent = Intent(this, InformationActivity::class.java)
        val details = "Url : " + data.url + "\n" + "Largeur : " + data.width + " px\n" + "Hauteur : " + data.height + " px\n" + "Nombre de textes à ajouter : " + data.box_count + "\n"
        intent.putExtra("EXTRA_NAME", data.name)
        intent.putExtra("EXTRA_URL", data.url)
        intent.putExtra("EXTRA_DETAILS", details)
        startActivity(intent)
    }
}