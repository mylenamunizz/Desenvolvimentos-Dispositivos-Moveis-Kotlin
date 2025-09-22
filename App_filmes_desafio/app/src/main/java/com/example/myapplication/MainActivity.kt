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

    private lateinit var btn_login: Button
    private lateinit var txt_usuario: TextView
    private lateinit var txt_senha: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_login = findViewById(R.id.btn_login)
        txt_usuario = findViewById(R.id.txt_usuario);
        txt_senha = findViewById(R.id.txt_senha);

        btn_login.setOnClickListener() { FazerLogin() }
    }

    private fun FazerLogin() {
        val usuario = txt_usuario.text.toString()
        val senha = txt_senha.text.toString()

        if (usuario.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos para fazer o login", Toast.LENGTH_SHORT).show()
            return
        }

        if (usuario == "admin" && senha == "12345") {
            val buttonClick = findViewById<Button>(R.id.btn_login )
            buttonClick.setOnClickListener()
            {
                val novaView = Intent(this, Cadastrar::class.java);
                startActivity(novaView);
            }

        } else {
            Toast.makeText(this, "Usuário não identificado.", Toast.LENGTH_SHORT).show()
        }

    }


}