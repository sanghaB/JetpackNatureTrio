package com.example.datajetpackapplication.domain.usecase

import com.example.datajetpackapplication.data.model.ListItems
import com.example.datajetpackapplication.domain.enumclass.Category
import com.example.datajetpackapplication.domain.repository.ListRepository


class GetListItemsUseCase(private val repository: ListRepository) {
    fun getList(category: Category): List<ListItems> {
        return when (category) {
            Category.FRUITS -> repository.getFruits()
            Category.ANIMALS -> repository.getAnimals()
            Category.FLOWERS -> repository.getFlowers()
        }
    }
}

