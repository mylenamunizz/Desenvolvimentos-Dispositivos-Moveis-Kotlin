package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.models.ItemLista

class Cadastrar : AppCompatActivity() {

    private lateinit var cadastrarButton: Button
    private lateinit var verListaButton: Button

    private lateinit var txtNome: EditText
    private lateinit var txtValor: EditText
    private lateinit var txtLink: EditText


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastrar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cadastrarButton = findViewById(R.id.buttonCadastrar)
        verListaButton = findViewById(R.id.verListaButton)

        txtNome = findViewById(R.id.txtNome)
        txtValor = findViewById(R.id.txtValor)
        txtLink = findViewById(R.id.txtLink)

        verListaButton.setOnClickListener { VerLista() }
        cadastrarButton.setOnClickListener() { Cadastrar() }
    }

    @SuppressLint("NotConstructor")
    fun Cadastrar() {

        val nome = txtNome.text.toString()
        val valor = txtValor.text.toString().toFloat()
        val link = txtLink.text.toString()

        ItemData.itens.add(ItemLista(nome, valor, link))
        Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

    }

    private fun VerLista() {
        val novaView = Intent(this, ListaActivity::class.java);
        startActivity(novaView);
    }
}