package com.example.minhaprova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.minhaprova.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.text1.text = viewModel._text1
        binding.text2.text = viewModel._text2

        val prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        var soUmaVez = prefs.getBoolean("soUmaVez", true);

        if(soUmaVez){
            Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_LONG ).show();
            var editor = prefs.edit();
            editor.putBoolean("soUmaVez", false).apply();
        }

        binding.button1.setOnClickListener {
            val i = Intent(this, ActivityAcao1::class.java)
            startActivityForResult(i, 1)
        }

        binding.button2.setOnClickListener {
            val dialogFrag = QuerCafe()
            dialogFrag.show(supportFragmentManager, "Dialog")
        }

        binding.button3.setOnClickListener {
            val i = Intent(this, ActivityAcao2::class.java)
            startActivityForResult(i, 2)
        }

        binding.button4.setOnClickListener {
            val i = Intent(this, ActivityAcao3::class.java)
            startActivityForResult(i, 3)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            var aux_result = data?.getStringExtra("RESULTADO").toString();
            //println(aux_result)
            when (requestCode) {
                1 -> {
                    viewModel._text1 = aux_result;
                    binding.text1.text = viewModel._text1;
                }
                2 -> {
                    //viewModel._text2 = aux_result;
                    binding.text2.text = aux_result;
                }
            }
        }else{
            when (requestCode) {
                1 -> {
                    Snackbar.make(
                            binding.mainlayout,
                            "CANCELADO",
                            Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}