package br.com.rafael.eletriccarapp.domain

data class Carro(
    val id: Int,
    val preco: String,
    val bateria: String,
    val potencia: String,
    val recarga: String,
    val imagem: String
)