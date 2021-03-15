package com.example.minhaprova

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class QuerCafe: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
                .setTitle("Pergunta importante!")

        builder.setMessage("Gostaria de uma xícara de café?")
                .setPositiveButton("Sim") {dialog, i ->
                    Toast.makeText(activity, "Ótimo", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Não") {dialog, i ->
                    Toast.makeText(activity, "Fica para a próxima", Toast.LENGTH_SHORT).show()
                }
        return builder.create()
    }
}