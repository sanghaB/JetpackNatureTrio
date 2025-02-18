package com.example.datajetpackapplication.data.model

data class ListAnalysisResult(
    val categoryCounts: Map<String, Int>,
    val topThreeCharacters: List<Pair<Char, Int>>
)
