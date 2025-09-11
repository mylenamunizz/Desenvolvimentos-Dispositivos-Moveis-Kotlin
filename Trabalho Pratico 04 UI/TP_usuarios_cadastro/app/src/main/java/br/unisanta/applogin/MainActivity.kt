package br.unisanta.applogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var senhaInput: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnCadastrar: Button
    private lateinit var txtEsqueceu: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.edt_email)
        senhaInput = findViewById(R.id.edt_senha)
        btnLogin = findViewById(R.id.btn_logar)
        btnCadastrar = findViewById(R.id.btn_cadastrar)
        txtEsqueceu = findViewById(R.id.txv_esqueceuasenha)

        // LOGIN
        btnLogin.setOnClickListener {
            val email = emailInput.text.toString()
            val senha = senhaInput.text.toString()

            val usuario = UsuarioRepository.usuarios.find { it.email == email && it.senha == senha }

            if (usuario != null) {
                Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show()

                // 👉 Abre a tela que lista os usuários
                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        // CADASTRO
        btnCadastrar.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val senha = senhaInput.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (UsuarioRepository.usuarios.any { it.email == email }) {
                Toast.makeText(this, "Usuário já cadastrado!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            UsuarioRepository.addUsuario(Usuario(email, senha))
            Toast.makeText(this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show()

            // 🔑 garante que os campos ficam realmente limpos
            emailInput.setText("")
            senhaInput.setText("")
            emailInput.requestFocus()

            Log.d("DEBUG", "Usuários cadastrados até agora: ${UsuarioRepository.usuarios.map { it.email }}")

        }


        // ESQUECEU A SENHA
        txtEsqueceu.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Esqueceu a Senha?")
                .setMessage("Fale com o administrador.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}
