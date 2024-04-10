package com.example.checkpoint2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalc = findViewById<Button>(R.id.buttonCalculadora)
        val buttonContaTel = findViewById<Button>(R.id.buttonContaTel)
        val buttonAluno = findViewById<Button>(R.id.buttonAluno)

        buttonCalc.setOnClickListener{
            goToCalculadora()
        }

        buttonContaTel.setOnClickListener {
            goToContaTelefone()
        }

        buttonAluno.setOnClickListener {
            showAluno()
        }
    }

    private fun showAluno() {
        val builder = AlertDialog.Builder(this, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
        builder.setTitle("Desenvolvido por")
        builder.setMessage("Danilo Araujo Mendonça \nRM:99752")
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

    private fun goToContaTelefone() {
        val intent = Intent(this, ContaTelActivity::class.java)

        startActivity(intent)
    }

    private fun goToCalculadora() {

        val intent = Intent(this, CalculadoraActivity::class.java)

        startActivity(intent)
    }
}