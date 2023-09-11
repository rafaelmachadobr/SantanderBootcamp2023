package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.eletriccarapp.presentation.CalculadoraAutonomiaActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular: Button
    lateinit var lista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListeners()
        setupList()
    }

    fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
        lista = findViewById(R.id.lv_informacoes)
    }

    fun setupList() {
        var dados = arrayOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)
        lista.adapter = adapter
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
    }
}