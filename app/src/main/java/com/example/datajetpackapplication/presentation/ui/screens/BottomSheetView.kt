package com.example.datajetpackapplication.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datajetpackapplication.domain.model.ListItems
import com.example.datajetpackapplication.domain.usecase.ListAnalysisUseCase


@Composable
fun rememberBottomSheetState(): MutableState<Boolean> {
    return remember { mutableStateOf(false) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetHost(
    showSheet: MutableState<Boolean>,
    listItems: List<ListItems>,
    useCase: ListAnalysisUseCase = ListAnalysisUseCase()
) {
    if (showSheet.value) {
        val analysisResult = useCase.analyzeList(listItems)

        ModalBottomSheet(
            onDismissRequest = { showSheet.value = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Number of Fruits: ${analysisResult.categoryCounts.size}",
                    fontSize = 20.sp,
                    color = Color.Black
                )

                analysisResult.categoryCounts.forEach { (category, count) ->
                    Text(text = "$category: $count items", fontSize = 16.sp, color = Color.DarkGray)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Top 3 Occurring Characters:", fontSize = 18.sp, color = Color.Black)
                analysisResult.topThreeCharacters.forEach { (char, count) ->
                    Text(text = "$char = $count", fontSize = 16.sp, color = Color.DarkGray)
                }
            }
        }
    }
}

