package br.com.rafael.eletriccarapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var preco : EditText
    lateinit var btnCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupListeners()
    }

    fun setupViews() {
        preco = findViewById(R.id.et_preco_kwh)
        btnCalcular = findViewById(R.id.btn_calcular)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            val precoDigitado = preco.text
            Log.d("Preço digitado ->", precoDigitado.toString())
        }
    }
}