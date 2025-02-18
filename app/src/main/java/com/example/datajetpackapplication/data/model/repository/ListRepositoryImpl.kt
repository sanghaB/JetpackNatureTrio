package com.example.datajetpackapplication.data.model.repository

import com.example.datajetpackapplication.R
import com.example.datajetpackapplication.data.model.ListItems
import com.example.datajetpackapplication.domain.repository.ListRepository
//data
//model
//repository
class ListRepositoryImpl : ListRepository {
    override fun getFruits(): List<ListItems> {
        return listOf(
            ListItems(R.drawable.ic_fruits, "Apple", "A sweet red fruit"),
            ListItems(R.drawable.ic_fruits, "Banana", "A yellow fruit"),
            ListItems(R.drawable.ic_fruits, "Mango", "King of fruits"),
            ListItems(R.drawable.ic_fruits, "Apple", "A sweet red fruit"),
            ListItems(R.drawable.ic_fruits, "Banana", "A yellow fruit"),
            ListItems(R.drawable.ic_fruits, "Mango", "King of fruits"),
            ListItems(R.drawable.ic_fruits, "Apple", "A sweet red fruit"),
            ListItems(R.drawable.ic_fruits, "Banana", "A yellow fruit"),
            ListItems(R.drawable.ic_fruits, "Mango", "King of fruits"),
            ListItems(R.drawable.ic_fruits, "Apple", "A sweet red fruit"),
            ListItems(R.drawable.ic_fruits, "Banana", "A yellow fruit"),
            ListItems(R.drawable.ic_fruits, "Mango", "King of fruits")
        )
    }

    override fun getAnimals(): List<ListItems> {
        return listOf(
            ListItems(R.drawable.ic_animals, "Lion", "King of Jungle"),
            ListItems(R.drawable.ic_animals, "Elephant", "Largest land animal"),
            ListItems(R.drawable.ic_animals, "Tiger", "National animal of India"),
            ListItems(R.drawable.ic_animals, "Lion", "King of Jungle"),
            ListItems(R.drawable.ic_animals, "Elephant", "Largest land animal"),
            ListItems(R.drawable.ic_animals, "Tiger", "National animal of India"),
            ListItems(R.drawable.ic_animals, "Lion", "King of Jungle"),
            ListItems(R.drawable.ic_animals, "Elephant", "Largest land animal"),
            ListItems(R.drawable.ic_animals, "Tiger", "National animal of India"),
            ListItems(R.drawable.ic_animals, "Lion", "King of Jungle"),
            ListItems(R.drawable.ic_animals, "Elephant", "Largest land animal"),
            ListItems(R.drawable.ic_animals, "Tiger", "National animal of India")
        )
    }

    override fun getFlowers(): List<ListItems> {
        return listOf(
            ListItems(R.drawable.ic_flowers, "Rose", "Symbol of love"),
            ListItems(R.drawable.ic_flowers, "Lily", "White flower"),
            ListItems(R.drawable.ic_flowers, "Sunflower", "Follows the sun"),
            ListItems(R.drawable.ic_flowers, "Rose", "Symbol of love"),
            ListItems(R.drawable.ic_flowers, "Lily", "White flower"),
            ListItems(R.drawable.ic_flowers, "Sunflower", "Follows the sun"),
            ListItems(R.drawable.ic_flowers, "Rose", "Symbol of love"),
            ListItems(R.drawable.ic_flowers, "Lily", "White flower"),
            ListItems(R.drawable.ic_flowers, "Sunflower", "Follows the sun"),
            ListItems(R.drawable.ic_flowers, "Rose", "Symbol of love"),
            ListItems(R.drawable.ic_flowers, "Lily", "White flower"),
            ListItems(R.drawable.ic_flowers, "Sunflower", "Follows the sun")
        )
    }
}
