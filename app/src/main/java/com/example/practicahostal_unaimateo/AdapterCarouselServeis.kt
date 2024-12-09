package com.example.practicahostal_unaimateo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterCarouselServeis(val llista: List<Servei>) :
    RecyclerView.Adapter<AdapterCarouselServeis.ViewHolder>() {
    lateinit var parent: ViewGroup

    class ViewHolder(val vista: View) : RecyclerView.ViewHolder(vista) {
        val imatge = vista.findViewById<ImageView>(R.id.serveis_image)
        val nom = vista.findViewById<TextView>(R.id.nom_servei)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
        this.parent = parent
        return ViewHolder(layout.inflate(R.layout.serveis_carousel, parent, false))
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.setText(llista[position].nom)
        Glide.with(parent).load(llista[position].img_url)
            .placeholder(R.drawable.ic_launcher_foreground).into(holder.imatge)
    }
}