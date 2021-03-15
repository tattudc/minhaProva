package com.example.minhaprova

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.minhaprova.databinding.ActivityAcao1Binding


class ActivityAcao1 : AppCompatActivity() {
    lateinit var binding : ActivityAcao1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao1)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao1)



        binding.btnOk.setOnClickListener {
            var intent = Intent();
            var resultado = binding.editText.text.toString();
            if(resultado != ""){
                intent.putExtra("RESULTADO", resultado);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        }

        binding.btnCancelar.setOnClickListener {
            val intent = Intent();
            intent.putExtra("VOLTAR", "Cancelado");
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        }

    }
}