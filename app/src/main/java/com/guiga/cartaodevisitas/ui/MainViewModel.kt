package com.guiga.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guiga.cartaodevisitas.data.BusinessCard
import com.guiga.cartaodevisitas.data.BusinessCardRepository

class MainViewModel(private val businessCardrepository: BusinessCardRepository) : ViewModel() {

    fun insert(businessCard: BusinessCard){
        businessCardrepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<BusinessCard>>{
        return businessCardrepository.getAll()
    }

    class MainViewModelFactory(private val repository: BusinessCardRepository) :
            ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            // Aqui você deve retornar uma instância do ViewModel desejado
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}