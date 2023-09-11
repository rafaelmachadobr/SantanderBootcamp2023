package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.eletriccarapp.presentation.CalculadoraAutonomiaActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListeners()
    }

    fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
    }
}