package br.unisanta.appduastelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appduastelas.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        //tela inicial de cadastro de produto
        val edtNome = findViewById<EditText>(R.id.edt_titulo_livro)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabMostra = findViewById<FloatingActionButton>(R.id.fab_mostra)
        var livro = Livro("",  "")
        btnCadastrar.setOnClickListener{
            val titulo = edtNome.text.toString()
            val autor = edtAutor.text.toString()
            livro = Livro(titulo, autor)

            //mensagem de confirmação do cadastro
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro OK!")
            val dialog = builder.create()
            dialog.show()
            edtNome.text.clear()
            edtAutor.text.clear()
    }
        //botao que leva pra outra tela
        fabMostra.setOnClickListener {
            val intent = Intent(this, LivroActivity::class.java)
            intent.putExtra("livro", "Título do livro: ${livro.tituloLivro}\nNome do autor: ${livro.nomeAutor}")
            startActivity(intent)
        }



    }
}