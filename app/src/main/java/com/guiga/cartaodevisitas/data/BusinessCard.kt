package com.guiga.cartaodevisitas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BusinessCard (

    @PrimaryKey(autoGenerate = true)
    val id : Int ,
    val nome : String,
    val telefone : String,
    val empresa : String,
    val email :  String,
    val fundoPersonalizado : String
)