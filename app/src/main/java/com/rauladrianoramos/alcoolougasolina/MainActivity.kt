package com.rauladrianoramos.alcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText
    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var buttonCalcular: Button
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicialiarComponentesInterface()
        buttonCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoALcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoALcool, precoGasolina)

        if (resultadoValidacao) {

            val resultado = precoALcool.toDouble() / precoGasolina.toDouble()

            if (resultado >= 0.7) {
                textResult.text = "Melhor utilizar GASOLINA"
            }else{
                textResult.text = "Melhor utilizar ALCOOL"
            }
        }
    }

    private fun validarCampos(precoALcool: String, precoGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if (precoALcool.isEmpty()) {
            textInputAlcool.error = "Digite o preço do Alcool"
            return false
        } else if (precoGasolina.isEmpty()) {
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false
        }


        return true
    }


    private fun inicialiarComponentesInterface() {
        textInputAlcool = findViewById(R.id.text_Input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)
        textInputGasolina = findViewById(R.id.text_Input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)
        buttonCalcular = findViewById(R.id.button_calcular)
        textResult = findViewById(R.id.text_resultado)
    }
}