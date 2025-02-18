package com.example.datajetpackapplication.presentation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.datajetpackapplication.presentation.viewmodel.ListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPagerView(viewModel: ListViewModel, pagerState: PagerState) {
    val images by viewModel.images.collectAsState()
    val categories by viewModel.categories.collectAsState()

    LaunchedEffect(pagerState.currentPage) {
        viewModel.updateList(categories[pagerState.currentPage])
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(id = images[page]),
                        contentDescription = "Image $page",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(320.dp)
                            .align(Alignment.Center)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DotsIndicator(pagerState: PagerState, viewModel: ListViewModel, modifier: Modifier = Modifier) {
    val categories by viewModel.categories.collectAsState()

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        categories.indices.forEach { index ->
            Box(
                modifier = Modifier
                    .size(if (pagerState.currentPage == index) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (pagerState.currentPage == index) Color.Black else Color.Gray
                    )
                    .padding(4.dp)
            )
            if (index != categories.lastIndex) {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}





