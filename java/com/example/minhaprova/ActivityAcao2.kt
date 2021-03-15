package com.example.minhaprova

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.minhaprova.databinding.ActivityAcao2Binding

class ActivityAcao2 : AppCompatActivity() {
    lateinit var binding : ActivityAcao2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao2)

        binding.btnSalvar.setOnClickListener {
            val titulo = binding.editTitulo.text.toString()
            val autor = binding.editAutor.text.toString()
            val ano = binding.editAno.text.toString()
            val rating = binding.ratingBar.rating

            if(titulo != "" && autor != "" && ano != ""){
                var livroNovo = Livro(0, titulo, autor, ano.toInt(), rating);
                var database = LivroDBOpener(this);
                database.insert(livroNovo);

                var i = Intent();
                i.putExtra("RESULTADO", "cadastrado");
                setResult(Activity.RESULT_OK, i);
                finish();
            }else{
                Toast.makeText(this, "Preencha todos os dados!!!", Toast.LENGTH_SHORT ).show();
            }
        }

        binding.btnCancelar2.setOnClickListener {
            finish();
        }

    }
}