package com.example.minhaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.minhaprova.databinding.ActivityAcao3Binding

class ActivityAcao3 : AppCompatActivity() {
    lateinit var binding: ActivityAcao3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao3)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao3)

        //Abrir BD e chamar finds
        val dataBase = LivroDBOpener(this)
        var idInicial = 1
        var livro = dataBase.findById(idInicial)
        var todosLivros = dataBase.findAll()

        //Anexando o id = 1
        binding.textTitulo.text = "${livro.titulo}"
        binding.textAutor.text = "${livro.autor}"
        binding.textAno.text = "${livro.ano}"
        binding.textRating.text = "${livro.nota}"

        //Anterior do BD
        binding.btnAnt.setOnClickListener {
            if(idInicial > 1) binding.btnProx.isEnabled = true

            var mudarLivro = dataBase.findById(--idInicial)

            binding.textTitulo.text = "${mudarLivro.titulo}"
            binding.textAutor.text = "${mudarLivro.autor}"
            binding.textAno.text = "${mudarLivro.ano}"
            binding.textRating.text = "${mudarLivro.nota}"

            if(idInicial == 1) binding.btnAnt.isEnabled = false
            }

        //Próximo do BD
        binding.btnProx.setOnClickListener {

            var mudarLivro = dataBase.findById(++idInicial)

            binding.textTitulo.text = "${mudarLivro.titulo}"
            binding.textAutor.text = "${mudarLivro.autor}"
            binding.textAno.text = "${mudarLivro.ano}"
            binding.textRating.text = "${mudarLivro.nota}"

            if(idInicial > 1) binding.btnAnt.isEnabled = true
            if(idInicial == todosLivros.size) binding.btnProx.isEnabled = false
        }
    }

}
