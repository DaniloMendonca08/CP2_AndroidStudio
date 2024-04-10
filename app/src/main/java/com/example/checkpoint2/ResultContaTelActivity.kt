package com.example.checkpoint2

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultContaTelActivity : AppCompatActivity() {
    private lateinit var assinaturaTextView: TextView
    private lateinit var chamadaLocalTextView: TextView
    private lateinit var chamadaCelularTextView: TextView
    private lateinit var totalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultcontatel)

        assinaturaTextView = findViewById(R.id.txtAssinatura)
        chamadaLocalTextView = findViewById(R.id.txtChamadaLocal)
        chamadaCelularTextView = findViewById(R.id.txtChamadaCelular)
        totalTextView = findViewById(R.id.txtTotal)

        var minutosChamadaLocal = intent.getIntExtra(lblMinutosLocal, 0)
        var minutosChamadaCelular = intent.getIntExtra(lblMinutosCelular, 0)
        
        val totalMinutosChamadaLocal = minutosChamadaLocal * 0.04
        val totalMinutosChamadaCelular = minutosChamadaCelular * 0.20

        val backButton = findViewById<ImageButton>(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }

        assinaturaTextView.text = "Assinatura      : R$ 59.90"
        chamadaLocalTextView.text = "Chamada Local : R$ ${totalMinutosChamadaLocal}"
        chamadaCelularTextView.text = "Chamada Celular : R$ ${totalMinutosChamadaCelular}"
        val total = 59.90 + totalMinutosChamadaLocal + totalMinutosChamadaCelular
        totalTextView.text = "Total                    : R$ ${total}"
    }

//    private fun calculate(minutosChamadaLocal: Int, minutosChamadaCelular: Int): Double {
//        val totalMinutosChamadaLocal = minutosChamadaLocal * 0.04
//        val totalMinutosChamadaCelular = minutosChamadaCelular * 0.20
//
//    }

    companion object {
        const val lblMinutosLocal = "lbl_minutos_local"
        const val lblMinutosCelular = "lbl_minutos_celular"
    }
}