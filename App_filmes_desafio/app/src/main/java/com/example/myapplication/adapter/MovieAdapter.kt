package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FilmeData
import com.example.myapplication.R
import com.example.myapplication.models.FilmeLista

class MovieAdapter(private val filmeList: List<FilmeLista>) : RecyclerView.Adapter<MovieAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val descricaoTextView: TextView = itemView.findViewById(R.id.txt_viewDescricao)
        val tituloTextView: TextView = itemView.findViewById(R.id.txt_viewTitulo)
        val notaTextView: TextView = itemView.findViewById(R.id.txt_viewNota)
        val itemVideo: VideoView = itemView.findViewById(R.id.videoView)  // Alterado para VideoView
        val buttonApagar: Button = itemView.findViewById(R.id.btn_apagar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = filmeList[position]

        val videoURL = item.link // Aqui o link do vídeo é obtido

        holder.itemVideo.setVideoPath(videoURL) // Configura o caminho do vídeo no VideoView

        holder.itemVideo.setOnPreparedListener {
            holder.itemVideo.start() // Inicia a reprodução
        }

        holder.descricaoTextView.text = item.descricao
        holder.tituloTextView.text = item.titulo
        holder.notaTextView.text = item.nota.toString()

        holder.buttonApagar.setOnClickListener {
            // Remove o item da lista
            FilmeData.itens.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = filmeList.size
}
