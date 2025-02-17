package com.example.datajetpackapplication.domain.usecase

import com.example.datajetpackapplication.model.ListItems
import com.example.datajetpackapplication.domain.repository.ListRepository

class GetListItemsUseCase(private val repository: ListRepository) {
    fun getList(category: String): List<ListItems> {
        return when (category) {
            "fruits" -> repository.getFruits()
            "animals" -> repository.getAnimals()
            "flowers" -> repository.getFlowers()
            else -> emptyList()
        }
    }
}
