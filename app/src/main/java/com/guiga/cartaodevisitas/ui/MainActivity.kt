package com.guiga.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.guiga.cartaodevisitas.R
import com.guiga.cartaodevisitas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners(){
        binding.faFloatButton.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }
}