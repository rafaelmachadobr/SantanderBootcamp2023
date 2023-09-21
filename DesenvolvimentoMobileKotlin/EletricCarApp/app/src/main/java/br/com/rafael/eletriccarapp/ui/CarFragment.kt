package br.com.rafael.eletriccarapp.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.rafael.eletriccarapp.R
import br.com.rafael.eletriccarapp.data.CarsApi
import br.com.rafael.eletriccarapp.domain.Carro
import br.com.rafael.eletriccarapp.local.CarRepository
import br.com.rafael.eletriccarapp.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONTokener
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {
    lateinit var fabCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView
    lateinit var progress: ProgressBar
    lateinit var noInternetImage: ImageView
    lateinit var noInternetText: TextView
    lateinit var carsApi: CarsApi

    var carrosArray: ArrayList<Carro> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRetrofit()
        setupView(view)
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        if (checkForInternet(context)) {
//            callService()
            getAllCars()
        } else {
            emptyState()
        }
    }

    fun getAllCars() {
        carsApi.getAllCars().enqueue(object : Callback<List<Carro>> {
            override fun onResponse(call: retrofit2.Call<List<Carro>>, response: Response<List<Carro>>) {
                if (response.isSuccessful) {
                    progress.isVisible = false
                    noInternetImage.isVisible = false
                    noInternetText.isVisible = false
                    response.body()?.let {
                        setupList(it)
                    }
                } else {
                    Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Carro>>, t: Throwable) {
                Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://igorbag.github.io/cars-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        carsApi = retrofit.create(CarsApi::class.java)
    }

    fun emptyState() {
        progress.isVisible = false
        listaCarros.isVisible = false
        noInternetImage.isVisible = true
        noInternetText.isVisible = true
    }

    fun setupView(view: View) {
        view.apply {
            fabCalcular = findViewById(R.id.fab_calcular)
            listaCarros = findViewById(R.id.rv_lista_carros)
            progress = findViewById(R.id.pb_loader)
            noInternetImage = findViewById(R.id.iv_empty_state)
            noInternetText = findViewById(R.id.tv_no_wifi)
        }
    }

    fun setupList(lista: List<Carro>) {
        val carroAdapter = CarAdapter(lista)
        listaCarros.apply {
            isVisible = true
            adapter = carroAdapter
        }
        carroAdapter.carItemLister = { carro ->
            val isSaved = CarRepository(requireContext()).save(carro)
        }
    }

    fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalculadoraAutonomiaActivity::class.java))
        }
    }

    fun callService() {
        val urlBase = "https://igorbag.github.io/cars-api/cars.json"
        progress.isVisible = true
        MyTask().execute(urlBase)
    }

    fun checkForInternet(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    inner class MyTask : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progress.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg url: String?): String {
            var urlConnection: HttpURLConnection? = null

            try {
                var urlBase = URL(url[0])

                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000
                urlConnection.setRequestProperty("Accept", "application/json")

                val responseCode = urlConnection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val response = urlConnection.inputStream.bufferedReader().use { it.readText() }
                    publishProgress(response)
                } else {
                    println("Erro na requisição")
                }

            } catch (ex: Exception) {
                ex.printStackTrace()
            } finally {
                urlConnection?.disconnect()
            }

            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                val jsonArray = JSONTokener(values[0]).nextValue() as JSONArray

                for (i in 0 until jsonArray.length()) {
                    val id = jsonArray.getJSONObject(i).getString("id")
                    val preco = jsonArray.getJSONObject(i).getString("preco")
                    val bateria = jsonArray.getJSONObject(i).getString("bateria")
                    val potencia = jsonArray.getJSONObject(i).getString("potencia")
                    val recarga = jsonArray.getJSONObject(i).getString("recarga")
                    val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")

                    val model = Carro(id.toInt(), preco, bateria, potencia, recarga, urlPhoto, false)
                    carrosArray.add(model)
                }
                progress.isVisible = false
                noInternetImage.isVisible = false
                noInternetText.isVisible = false
//                setupList()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}