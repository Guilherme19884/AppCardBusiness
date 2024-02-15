package com.guiga.cartaodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.guiga.cartaodevisitas.App
import com.guiga.cartaodevisitas.databinding.ActivityMainBinding
import com.guiga.cartaodevisitas.util.Image


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel : MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvListCards.adapter = adpter

        getAllBusinessCard()
        insertListeners()
    }

    private val adpter by lazy { BusinessCardAdpter() }
    private fun insertListeners(){
        binding.faFloatButton.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
        adpter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this) { businessCards ->
            adpter.submitList(businessCards)
        }
    }
}