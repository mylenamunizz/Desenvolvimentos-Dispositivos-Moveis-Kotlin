package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.MovieAdapter

class ListaFilmes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var MovieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes)

        title = "Filmes Cadastrados"

        recyclerView = findViewById(R.id.recyclewViewFilmes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        MovieAdapter = MovieAdapter(FilmeData.itens)
        recyclerView.adapter = MovieAdapter

    }

}