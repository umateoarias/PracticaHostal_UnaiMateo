package com.example.practicahostal_unaimateo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterCarouselActivitats(val llista: List<Activitat>) :
    RecyclerView.Adapter<AdapterCarouselActivitats.ViewHolder>() {
        lateinit var parent:ViewGroup
    class ViewHolder(val vista: View) : RecyclerView.ViewHolder(vista) {
        val imatge = vista.findViewById<ImageView>(R.id.ivCarousel)
        val nom = vista.findViewById<TextView>(R.id.nom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
        this.parent = parent
        return ViewHolder(layout.inflate(R.layout.activitats_carousel, parent, false))
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.setText(llista[position].nom)
        Glide.with(parent).load(llista[position].img_url).placeholder(R.drawable.ic_launcher_foreground).into(holder.imatge)
        holder.itemView.setOnClickListener {
            val dialogView = LayoutInflater.from(parent.context).inflate(R.layout.dialog_layout, null)
            var dialogBuilder = AlertDialog.Builder(parent.context)
            dialogBuilder.setView(dialogView)

            val title = dialogView.findViewById<TextView>(R.id.titol_dialog)
            title.setText(llista[position].nom)
            val desc = dialogView.findViewById<TextView>(R.id.desc_dialog)
            desc.setText(llista[position].descripcio)
            val image = dialogView.findViewById<ImageView>(R.id.image_dialog)
            Glide.with(parent).load(llista[position].img_url).into(image)

            var dialog = dialogBuilder.create()
            dialog.show()
        }
    }
}
