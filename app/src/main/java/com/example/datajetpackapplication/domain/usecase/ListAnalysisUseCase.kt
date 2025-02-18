package com.example.datajetpackapplication.domain.usecase

import com.example.datajetpackapplication.data.model.ListAnalysisResult
import com.example.datajetpackapplication.data.model.ListItems

class ListAnalysisUseCase {
    fun analyzeList(listItems: List<ListItems>): ListAnalysisResult {
        val categoryCounts = listItems.groupBy { it.title }.mapValues { it.value.size }

        val charCount = listItems
            .flatMap { it.title.lowercase().toList() }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .take(3)

        return ListAnalysisResult(categoryCounts, charCount)
    }
}