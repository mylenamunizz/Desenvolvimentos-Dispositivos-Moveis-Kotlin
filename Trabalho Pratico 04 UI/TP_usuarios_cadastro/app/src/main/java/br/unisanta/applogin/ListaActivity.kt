package br.unisanta.applogin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)

        recyclerView = findViewById(R.id.recyclerUsuarios)

        // 👉 Passa a lista original do repositório para o adapter
        adapter = UsuarioAdapter(UsuarioRepository.usuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // 👉 Registra o listener para ser notificado sempre que houver novos usuários
        UsuarioRepository.addOnChangeListener {
            // Notifica o adapter que a lista mudou e atualiza a tela
            adapter.notifyDataSetChanged()
        }

        Log.d("DEBUG", "ListaActivity recebeu usuários: ${UsuarioRepository.usuarios.map { it.email }}")

    }
}
