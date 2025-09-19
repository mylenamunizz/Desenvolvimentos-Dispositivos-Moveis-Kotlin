package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.ItemAdapter

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        title = "Itens Cadastrados"

        recyclerView = findViewById(R.id.recyclewViewItens)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemAdapter = ItemAdapter(ItemData.itens)
        recyclerView.adapter = itemAdapter

    }

}