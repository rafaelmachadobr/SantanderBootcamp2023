package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.rafael.eletriccarapp.data.CarFactory
import br.com.rafael.eletriccarapp.ui.CalculadoraAutonomiaActivity
import br.com.rafael.eletriccarapp.ui.adapter.CarAdapter

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

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
        listaCarros = findViewById(R.id.rv_lista_carros)
    }

    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
    }
}