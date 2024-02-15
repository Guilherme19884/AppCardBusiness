package com.guiga.cartaodevisitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.guiga.cartaodevisitas.App
import com.guiga.cartaodevisitas.R
import com.guiga.cartaodevisitas.data.BusinessCard
import com.guiga.cartaodevisitas.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel : MainViewModel by viewModels{
        MainViewModel.MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners(){
        binding.btBtnClose.setOnClickListener {
            finish()
        }

        binding.btBtnConfirm.setOnClickListener{
            val businessCard  = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelephone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}