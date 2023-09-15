package br.com.rafael.eletriccarapp.data

import br.com.rafael.eletriccarapp.domain.Carro
import retrofit2.Call
import retrofit2.http.GET

interface CarsApi {
    @GET("cars.json")
    fun getAllCars(): Call<List<Carro>>
}