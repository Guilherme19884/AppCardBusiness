package com.guiga.cartaodevisitas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BusinessCard (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nome : String,
    val empresa : String,
    val email :  String,
    val fundoPersonalido : String
)