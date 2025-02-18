package com.example.datajetpackapplication.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.datajetpackapplication.presentation.ui.screens.ViewPagerWithList
import com.example.datajetpackapplication.presentation.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           ViewPagerWithList(viewModel)

        }
    }
}

//NAvigation latest Object vala
