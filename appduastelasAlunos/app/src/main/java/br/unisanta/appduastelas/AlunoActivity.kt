package br.unisanta.appduastelas

import kotlin.random.Random
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtAluno = findViewById<TextView>(R.id.edt_matricula1)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)
        val aluno = intent.getStringExtra("aluno")
        val btnMatricula = findViewById<Button>(R.id.btn_matricula)

        edtAluno.text = "Nome do Aluno: $aluno"



        btnMatricula.setOnClickListener{
            val numeroMatricula = (1..5).map { Random.nextInt(0, 10) }.joinToString("")
            val edtMatri = findViewById<TextView>(R.id.edt_matricula2)

            edtMatri.text = "Número de Matrícula: $numeroMatricula"
        }
        fabVoltar.setOnClickListener{
            finish()
        }
    }
}