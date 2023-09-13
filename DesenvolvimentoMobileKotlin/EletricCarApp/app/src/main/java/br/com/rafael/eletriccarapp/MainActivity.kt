package br.com.rafael.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import br.com.rafael.eletriccarapp.data.CarFactory
import br.com.rafael.eletriccarapp.ui.CalculadoraAutonomiaActivity
import br.com.rafael.eletriccarapp.ui.adapter.CarAdapter
import br.com.rafael.eletriccarapp.ui.adapter.TabsAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular: Button
    lateinit var listaCarros: RecyclerView
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupListeners()
        setupList()
        setupTabs()
    }

    fun setupView() {
        tabLayout = findViewById(R.id.tab_layout)
        btnCalcular = findViewById(R.id.btn_calcular)
        listaCarros = findViewById(R.id.rv_lista_carros)
        viewPager = findViewById(R.id.vp_view_pager)
    }

    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    fun setupTabs() {
        val tabsAdapter = TabsAdapter(this)
        viewPager.adapter = tabsAdapter
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(this, CalculadoraAutonomiaActivity::class.java))
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { viewPager.currentItem = it.position }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Não faz nada
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Não faz nada
            }
        })
    }
}