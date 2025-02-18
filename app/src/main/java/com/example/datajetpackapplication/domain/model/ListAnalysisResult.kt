package com.example.datajetpackapplication.domain.model

data class ListAnalysisResult(
    val categoryCounts: Map<String, Int>,
    val topThreeCharacters: List<Pair<Char, Int>>
)
