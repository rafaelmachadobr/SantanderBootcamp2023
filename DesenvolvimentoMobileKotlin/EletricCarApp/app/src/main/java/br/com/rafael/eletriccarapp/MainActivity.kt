package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.eletriccarapp.presentation.CalculadoraAutonomiaActivity

class MainActivity : AppCompatActivity() {
    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var btnCalcular: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupListeners()
    }

    fun setupViews() {
//        preco = findViewById(R.id.et_preco_kwh)
//        kmPercorrido = findViewById(R.id.et_km_percorrido)
//        resultado = findViewById(R.id.tv_resultado)
//        btnCalcular = findViewById(R.id.btn_calcular)
        btnCalcular = findViewById(R.id.btn_calcular)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
//            calcular()
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
    }

    fun calcular() {
        val preco = preco.text.toString().toFloat()
        val kmPercorrido = kmPercorrido.text.toString().toFloat()
        val result = preco / kmPercorrido

        resultado.text = "R$ $result"
    }
}