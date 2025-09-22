package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.models.FilmeLista

class Cadastrar : AppCompatActivity() {

    private lateinit var cadastrarButton: Button
    private lateinit var verFilmeBtn: Button

    private lateinit var txtTitulo: EditText
    private lateinit var txtDescricao: EditText
    private lateinit var seekBarNota: SeekBar
    private lateinit var txtNota: TextView
    private lateinit var txtLinkVideo: EditText
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastrar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cadastrarButton = findViewById(R.id.btn_cadastrar)
        verFilmeBtn = findViewById(R.id.verFilmeButton)

        txtTitulo = findViewById(R.id.txt_titulo)
        txtDescricao = findViewById(R.id.txt_descricao)
        seekBarNota = findViewById(R.id.seekBar)
        txtLinkVideo = findViewById(R.id.txt_link)



        verFilmeBtn.setOnClickListener { VerLista() }
        cadastrarButton.setOnClickListener { Cadastrar() }
    }

    @SuppressLint("NotConstructor")
    fun Cadastrar() {
        // Pegar os valores dos campos
        val titulo = txtTitulo.text.toString()
        val descricao = txtDescricao.text.toString()
        val nota = seekBarNota.progress.toFloat()  // Pegando o valor da SeekBar
        val linkVideo = txtLinkVideo.text.toString()  // Pegando o link do vídeo

        // Verificando se os campos não estão vazios
        if (titulo.isNotBlank() && descricao.isNotBlank() && linkVideo.isNotBlank()) {


            // Adicionando filme na lista
            FilmeData.itens.add(FilmeLista(titulo, descricao, nota, linkVideo))

            // Exibindo mensagem de sucesso
            Toast.makeText(this, "Filme cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

            // Limpando os campos após o cadastro (opcional)
            txtTitulo.text.clear()
            txtDescricao.text.clear()
            txtLinkVideo.text.clear()
            seekBarNota.progress = 5  // Resetando a SeekBar para o valor inicial
        } else {
            // Exibindo mensagem de erro se algum campo estiver vazio
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun VerLista() {
        val novaView = Intent(this, ListaFilmes::class.java)
        startActivity(novaView)
    }
}
