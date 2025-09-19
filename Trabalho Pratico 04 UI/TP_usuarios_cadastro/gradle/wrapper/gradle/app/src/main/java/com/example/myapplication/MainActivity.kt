package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var txtUsuario: TextView
    private lateinit var txtSenha: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin = findViewById(R.id.btnLogin)
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);

        btnLogin.setOnClickListener() { FazerLogin() }
    }

    private fun FazerLogin() {
        val usuario = txtUsuario.text.toString()
        val senha = txtSenha.text.toString()

        if (usuario.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos para fazer o login", Toast.LENGTH_SHORT).show()
            return
        }

        if (usuario == "admin" && senha == "123") {
            val novaView = Intent(this, Cadastrar::class.java);
            startActivity(novaView);
        } else {
            Toast.makeText(this, "Usuário não identificado.", Toast.LENGTH_SHORT).show()
        }

    }


}