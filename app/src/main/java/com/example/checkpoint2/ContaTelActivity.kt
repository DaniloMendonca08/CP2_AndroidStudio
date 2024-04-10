package com.example.checkpoint2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContaTelActivity: AppCompatActivity() {

    private lateinit var minutosLocalEditText: EditText
    private lateinit var minutosCelularEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatelefone)

    minutosLocalEditText = findViewById(R.id.editTxtMinutosLocal)
    minutosCelularEditText = findViewById(R.id.editTxtMinutosCelular)

    val calculateButton = findViewById<Button>(R.id.btnCalcContaTel)
    val backButton = findViewById<ImageButton>(R.id.backButton)

        calculateButton.setOnClickListener {
            calculateAndShowResult()
        }

        backButton.setOnClickListener {
            finish()
        }

    }

    private fun calculateAndShowResult() {
        val minutosLocalInput = minutosLocalEditText.text.toString()
        val minutosCelularInput = minutosCelularEditText.text.toString()

        if (minutosLocalInput.isNotEmpty() && minutosCelularInput.isNotEmpty()) {
            val minutosLocal = minutosLocalInput.toInt()
            val minutosCelular = minutosCelularInput.toInt()

            val intent = Intent(this, ResultContaTelActivity::class.java)

            intent.putExtra(ResultContaTelActivity.lblMinutosLocal, minutosLocal)
            intent.putExtra(ResultContaTelActivity.lblMinutosCelular, minutosCelular)

            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Você deve passar um número de minutos para chamadas local e celular antes de calcular", Toast.LENGTH_SHORT).show()
        }
    }

}