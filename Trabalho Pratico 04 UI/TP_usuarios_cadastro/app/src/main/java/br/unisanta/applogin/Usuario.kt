package br.unisanta.applogin

data class Usuario(val email: String, val senha: String)

object UsuarioRepository {
    val usuarios = mutableListOf<Usuario>()

    private val listeners = mutableListOf<() -> Unit>()

    fun addUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        listeners.forEach { it() }
    }

    fun addOnChangeListener(listener: () -> Unit) {
        listeners.add(listener)
    }
}

