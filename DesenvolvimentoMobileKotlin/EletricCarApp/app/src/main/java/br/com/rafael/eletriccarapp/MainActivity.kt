package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rafael.eletriccarapp.presentation.CalculadoraAutonomiaActivity
import br.com.rafael.eletriccarapp.presentation.adapter.CarAdapter

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular: Button
    lateinit var listaCarros: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListeners()
        setupList()
    }

    fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
        listaCarros = findViewById(R.id.rv_lista_carros)
    }

    fun setupList() {
        var dados = arrayOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb")
        val adapter = CarAdapter(dados)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
    }
}