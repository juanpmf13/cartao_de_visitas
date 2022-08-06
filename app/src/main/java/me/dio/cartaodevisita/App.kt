package me.dio.cartaodevisita

import android.app.Application
import me.dio.cartaodevisita.data.AppDatabase
import me.dio.cartaodevisita.data.CartaoDeVisitasRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this)  }
    val repository by lazy {CartaoDeVisitasRepository(database.cartaoDao())}
}