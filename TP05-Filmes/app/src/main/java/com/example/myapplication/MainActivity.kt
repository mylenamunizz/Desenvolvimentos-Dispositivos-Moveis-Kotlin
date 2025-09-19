package com.example.myapplication
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meusfilmes.adapter.MovieAdapter
import com.example.meusfilmes.model.Movie


class MainActivity : AppCompatActivity() {

    private lateinit var edt_titulo: EditText
    private lateinit var edt_diretor: EditText
    private lateinit var btn_adicionar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var check_acao: CheckBox
    private lateinit var check_comedia: CheckBox
    private lateinit var check_drama: CheckBox
    private lateinit var check_romance: CheckBox
    private lateinit var check_terror: CheckBox
    private lateinit var check_animacao: CheckBox

    private lateinit var seekBarRating: SeekBar
    private lateinit var textRatingValue: TextView

    private val movieList = mutableListOf<Movie>()
    private var currentRating = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views
        edt_titulo = findViewById(R.id.edt_titulo)
        edt_diretor = findViewById(R.id.edt_diretor)
        btn_adicionar = findViewById(R.id.btn_adicionar)
        recyclerView = findViewById(R.id.recyclerViewMovies)
        check_acao = findViewById(R.id.check_acao)
        check_comedia = findViewById(R.id.check_comedia)
        check_drama = findViewById(R.id.check_drama)
        check_romance = findViewById(R.id.check_romance)
        check_terror = findViewById(R.id.check_terror)
        check_animacao = findViewById(R.id.check_animacao)
        seekBarRating = findViewById(R.id.seekBarRating)
        textRatingValue = findViewById(R.id.textRatingValue)

        // RecyclerView
        adapter = MovieAdapter(movieList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // SeekBar listener
        seekBarRating.max = 5
        seekBarRating.progress = currentRating
        textRatingValue.text = "Avaliação: ${seekBarRating.progress}/5"

        seekBarRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                currentRating = progress
                textRatingValue.text = "Avaliação: $progress/5"
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        // Botão adicionar
        btn_adicionar.setOnClickListener {
            val title = edt_titulo.text.toString().trim()
            val director = edt_diretor.text.toString().trim()

            // Validação simples
            if (title.isEmpty()) {
                edt_titulo.error = "Informe o título do filme."
                return@setOnClickListener
            }
            if (director.isEmpty()) {
                edt_diretor.error = "Informe o diretor"
                return@setOnClickListener
            }

            val genres = mutableListOf<String>()
            if (check_acao.isChecked) genres.add("Ação")
            if (check_comedia.isChecked) genres.add("Comédia")
            if (check_drama.isChecked) genres.add("Drama")
            if (check_romance.isChecked) genres.add("Romance")
            if (check_terror.isChecked) genres.add("Terror")
            if (check_animacao.isChecked) genres.add("Animação")

            val movie = Movie(
                title = title,
                director = director,
                genres = genres,
                rating = currentRating
            )

            adapter.addMovie(movie)

            // Limpa campos
            edt_titulo.text.clear()
            edt_diretor.text.clear()
            check_acao.isChecked = false
            check_comedia.isChecked = false
            check_drama.isChecked = false
            check_romance.isChecked = false
            check_terror.isChecked = false
            check_animacao.isChecked = false
            seekBarRating.progress = 0
        }

    }
}
