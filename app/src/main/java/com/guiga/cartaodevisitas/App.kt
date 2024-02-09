package com.guiga.cartaodevisitas

import android.app.Application
import com.guiga.cartaodevisitas.data.AppDatabase
import com.guiga.cartaodevisitas.data.BusinessCardrepository

class App : Application () {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardrepository(database.businessDao()) }
}