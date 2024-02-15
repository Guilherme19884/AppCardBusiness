package com.guiga.cartaodevisitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun businessDao(): BusinessCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).fallbackToDestructiveMigration() // Adiciona essa linha para migrar o banco de dados em caso de alterações no esquema
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Adicione o que deseja executar quando o banco de dados é criado
                        }
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // Adicione o que deseja executar quando o banco de dados é aberto
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
