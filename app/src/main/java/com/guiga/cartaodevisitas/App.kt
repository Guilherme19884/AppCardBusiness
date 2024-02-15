package com.guiga.cartaodevisitas

import android.app.Application
import com.guiga.cartaodevisitas.data.AppDatabase
import com.guiga.cartaodevisitas.data.BusinessCardRepository

class App : Application () {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}