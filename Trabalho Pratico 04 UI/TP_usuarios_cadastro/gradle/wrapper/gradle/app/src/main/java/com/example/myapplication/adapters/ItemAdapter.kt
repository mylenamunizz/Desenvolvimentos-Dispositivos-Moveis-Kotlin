package com.example.myapplication.adapters

import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ItemData
import com.example.myapplication.R
import com.example.myapplication.models.ItemLista
import java.net.URL
import java.util.concurrent.Executors

class ItemAdapter (private val itemList: List<ItemLista>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val valorTextView: TextView = itemView.findViewById(R.id.txtViewValor)
        val nomeTextView: TextView = itemView.findViewById(R.id.txtViewNome)
        val itemImage: ImageView = itemView.findViewById(R.id.imgItem)

        val buttonApagar: Button = itemView.findViewById(R.id.btnApagar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        executor.execute {
            val imageURL = item.link

            try {
                val `in` = URL(imageURL).openStream()
                val image = BitmapFactory.decodeStream(`in`)

                handler.post {
                    holder.itemImage.setImageBitmap(image)
                    holder.valorTextView.text = item.valor.toString()
                    holder.nomeTextView.text = item.nome
                }
            } catch (e: Exception) {
                e.printStackTrace()

                handler.post {
                    holder.valorTextView.text = item.valor.toString()
                    holder.nomeTextView.text = item.nome
                }
            }
        }

        holder.buttonApagar.setOnClickListener {
            ItemData.itens.removeAt(position);
            notifyDataSetChanged();
        }
    }

    override fun getItemCount() = itemList.size
}