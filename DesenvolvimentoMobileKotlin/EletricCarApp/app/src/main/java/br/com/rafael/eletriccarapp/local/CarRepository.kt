package br.com.rafael.eletriccarapp.local

import android.content.ContentValues
import android.content.Context
import br.com.rafael.eletriccarapp.domain.Carro

class CarRepository(private val context: Context) {
    fun save(carro: Carro): Boolean {
        var isSaved = false
        try {
            val dbHelper = CarDbHelper(context)
            val db = dbHelper.writableDatabase

            val values = ContentValues().apply {
                put(CarrosContract.CarEntry.COLUMN_NAME_PRECO, carro.preco)
                put(CarrosContract.CarEntry.COLUMN_NAME_BATERIA, carro.bateria)
                put(CarrosContract.CarEntry.COLUMN_NAME_POTENCIA, carro.potencia)
                put(CarrosContract.CarEntry.COLUMN_NAME_RECARGA, carro.recarga)
                put(CarrosContract.CarEntry.COLUMN_NAME_URL_PHOTO, carro.urlPhoto)
            }

            val inserted = db?.insert(CarrosContract.CarEntry.TABLE_NAME, null, values)

            if (inserted != null) {
                isSaved = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return isSaved
    }
}