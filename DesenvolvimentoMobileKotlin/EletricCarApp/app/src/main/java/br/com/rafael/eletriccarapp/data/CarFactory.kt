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
            "https://www.google.com.br"
        ),
        Carro(
            2,
            "R$ 200.000,00",
            "200 kWh",
            "150 cv",
            "20 min",
            "https://www.google.com.br"
        ),
        Carro(
            3,
            "R$ 100.000,00",
            "100 kWh",
            "100 cv",
            "10 min",
            "https://www.google.com.br"
        ),
        Carro(
            4,
            "R$ 50.000,00",
            "50 kWh",
            "50 cv",
            "5 min",
            "https://www.google.com.br"
        ),
    )
}