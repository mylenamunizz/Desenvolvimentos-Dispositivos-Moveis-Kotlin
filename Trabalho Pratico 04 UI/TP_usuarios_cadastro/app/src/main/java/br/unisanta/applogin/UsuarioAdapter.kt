package br.unisanta.applogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(private val lista: MutableList<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val email: TextView = itemView.findViewById(R.id.txtEmailItem)

        fun bind(usuarioAtual: Usuario) {
            email.text = usuarioAtual.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuarioAtual = lista[position]
        holder.bind(usuarioAtual)
    }

    override fun getItemCount(): Int = lista.size

}


