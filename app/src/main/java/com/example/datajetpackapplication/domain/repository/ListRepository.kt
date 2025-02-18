package com.example.datajetpackapplication.domain.repository

import com.example.datajetpackapplication.domain.model.ListItems

interface ListRepository {
    fun getFruits(): List<ListItems>
    fun getAnimals(): List<ListItems>
    fun getFlowers(): List<ListItems>
}