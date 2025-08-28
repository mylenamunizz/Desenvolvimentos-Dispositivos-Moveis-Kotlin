package br.unisanta.appduastelas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity(R.layout.activity_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTitulo = findViewById<TextView>(R.id.txv_cadastrados)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)
        val livro = intent.getStringExtra("livro")

        edtTitulo.text = "$livro"

        fabVoltar.setOnClickListener{
            finish()
        }
    }
}