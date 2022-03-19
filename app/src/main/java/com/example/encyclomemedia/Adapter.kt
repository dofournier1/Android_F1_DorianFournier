package com.example.encyclomemedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

// Classe Adapter qui associe les données du fichier JSON aux ViewHolder
// ViewHolder est une View qui contient la mise en page d'un élément individuel de la RecyclerView
// Fonction clickLitener en paramètre de l'Adapter est la fonction à appeler si l'utilisateur clique sur un élément de la liste
class Adapter (private val dataSet: List<Meme>, private val clickListener: (Meme) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    // Classe ViewHolder
    class ViewHolder(view: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val textView: TextView

        // Récupération des différents éléments de la View du ViewHolder
        init {
            imageView = view.findViewById(R.id.imageViewOnViewHolder)
            textView = view.findViewById(R.id.textViewOnViewHolder)

            // Définition du OnClickListener pour le ViewHolder qui renvoie l'indice de l'élément dans la liste
            itemView.setOnClickListener{
                clickAtPosition(adapterPosition)
            }
        }
    }

    // Création d'une nouvelle View dans le RecyclerView
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_holder_item, viewGroup, false)

        // Retour du nouveau ViewHolder avec la fonction à appeler au clique de l'élément de la liste
        return ViewHolder(view){
            clickListener(dataSet[it])
        }
    }

    // Remplace le contenu d'un ViewHolder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Récupération d'un élément du DataSet à cette position et remplacement du contenu de la vue par cet élément
        viewHolder.imageView.load(dataSet[position].url)
        viewHolder.textView.text = dataSet[position].name
    }

    // Retourne la taille du DataSet
    override fun getItemCount() = dataSet.size

}