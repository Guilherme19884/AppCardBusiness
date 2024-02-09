package com.guiga.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guiga.cartaodevisitas.databinding.ActivityAddBusinessCardBinding
import com.guiga.cartaodevisitas.databinding.ActivityMainBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners(){
        binding.btBtnClose.setOnClickListener {
            val intent = Intent(this, ActivityMainBinding::class.java)
            finish()
        }

        binding.btBtnConfirm.setOnClickListener{
        }
    }
}