package com.example.checkpoint2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var firstNumEditText: EditText
    private lateinit var secondNumEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val buttonCalcular = findViewById<Button>(R.id.btnCalcular)
        val backButton = findViewById<ImageButton>(R.id.backButton)

         firstNumEditText = findViewById(R.id.editTextVal1)
         secondNumEditText = findViewById(R.id.editTextVal2)

        buttonCalcular.setOnClickListener{
            CalculateNumbers()
        }

        backButton.setOnClickListener{
            finish()
        }
    }

    private fun CalculateNumbers() {
        val firstNumInput = firstNumEditText.text.toString()
        val secondNumInput = secondNumEditText.text.toString()

        val soma = findViewById<RadioButton>(R.id.rbSoma)
        val subtracao = findViewById<RadioButton>(R.id.rbSubtracao)
        val multiplicacao = findViewById<RadioButton>(R.id.rbMultiplicacao)
        val divisao = findViewById<RadioButton>(R.id.rbDivisao)


        if (firstNumInput.isNotEmpty() && secondNumInput.isNotEmpty()) {
            val firstNum = firstNumInput.toDouble()
            val secondNum = secondNumInput.toDouble()
            var resultado = 0.0

            if (soma.isChecked) {
                resultado = firstNum + secondNum
            }
            else if (subtracao.isChecked) {
                resultado = firstNum - secondNum
            }
            else if (multiplicacao.isChecked) {
                resultado = firstNum * secondNum
            }
            else if (divisao.isChecked) {
                resultado = firstNum / secondNum
            }

            Toast.makeText(this, "Resultado = ${resultado}", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Voce deve selecionar alguma operação e os valores para poder calcular", Toast.LENGTH_SHORT).show()
        }
    }
}
