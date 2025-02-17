package com.example.datajetpackapplication.presentation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.datajetpackapplication.R
import com.example.datajetpackapplication.presentation.viewmodel.ListViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPagerWithList(viewModel: ListViewModel) {
    val listItems by viewModel.listItems.collectAsState()
    val listState = rememberLazyListState()
    val showSheet = rememberBottomSheetState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredList = listItems.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.description.contains(searchQuery, ignoreCase = true)
    }
    val pagerState = rememberPagerState(pageCount = { 3 }) // Set the page count accordingly


    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                ) {
                    ViewPagerView(viewModel, pagerState)
                }

                DotsIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp)
                )
            }

            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 16.dp, bottom = 4.dp)
                ) {
                    SearchField(searchQuery) { query -> searchQuery = query }
                }
            }

            items(filteredList) { item ->
                ListItemCard(item)
            }
        }

        FloatingActionButton(
            onClick = { showSheet.value = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "Open Bottom Sheet")
        }
    }

    BottomSheetHost(showSheet, listItems)
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ViewPagerImages1() {
    val images = listOf(
        R.drawable.ic_flowers,
        R.drawable.ic_animals,
        R.drawable.ic_fruits
    )

    val pagerState = rememberPagerState(pageCount = { images.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.size(320.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Image $page",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(320.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                images.indices.forEach { index ->
                    Box(
                        modifier = Modifier
                            .size(if (pagerState.currentPage == index) 12.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                color = if (pagerState.currentPage == index) Color.Black else Color.Gray
                            )
                            .padding(4.dp)
                    )
                    if (index != images.lastIndex) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }

//            Spacer(modifier = Modifier.height(16.dp))
//            SearchField()
//            Spacer(modifier = Modifier.height(10.dp))
//            ListScreen(viewModel = ListViewModel(getListItemsUseCase = GetListItemsUseCase(repository = ListRepository())))
        }

    }

}
