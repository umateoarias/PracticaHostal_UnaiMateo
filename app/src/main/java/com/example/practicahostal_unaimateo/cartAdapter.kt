package com.example.practicahostal_unaimateo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicahostal_unaimateo.AdapterCarouselActivitats.ViewHolder
import org.w3c.dom.Text

class cartAdapter(val llista : List<Reserva>) : RecyclerView.Adapter<cartAdapter.ViewHolder>() {
    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista) {
        val textNom = vista.findViewById<TextView>(R.id.nomText)
        val textCognom = vista.findViewById<TextView>(R.id.cognomText)
        val textEmail = vista.findViewById<TextView>(R.id.emailText)
        val textTelef = vista.findViewById<TextView>(R.id.telefText)
        val dataInici = vista.findViewById<TextView>(R.id.dataInici)
        val dataFinal = vista.findViewById<TextView>(R.id.dataFinal)
        val preu = vista.findViewById<TextView>(R.id.preuText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
        return ViewHolder(layout.inflate(R.layout.cart_cardview, parent, false))
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textNom.setText(llista[position].nom)
        holder.textCognom.setText(llista[position].cognoms)
        holder.textEmail.setText(llista[position].email)
        holder.textTelef.setText(llista[position].numTelefon)
        holder.dataInici.setText(llista[position].dataInici.toString())
        holder.dataFinal.setText(llista[position].dataFinal.toString())
        holder.preu.setText(llista[position].preu.toString())
    }
}