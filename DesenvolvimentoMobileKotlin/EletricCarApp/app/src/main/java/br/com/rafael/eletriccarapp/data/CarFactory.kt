package br.com.rafael.eletriccarapp.data

import br.com.rafael.eletriccarapp.domain.Carro

object CarFactory {
    val list = listOf<Carro>(
        Carro(
            1,
            "R$ 300.000,00",
            "300 kWh",
            "200 cv",
            "30 min",
            "https://www.google.com.br",
            false
        ),
        Carro(
            2,
            "R$ 200.000,00",
            "200 kWh",
            "150 cv",
            "20 min",
            "https://www.google.com.br",
            true
        )
    )
}