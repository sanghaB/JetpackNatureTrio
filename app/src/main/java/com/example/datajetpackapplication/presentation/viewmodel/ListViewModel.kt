package com.example.datajetpackapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.datajetpackapplication.domain.usecase.GetListItemsUseCase
import com.example.datajetpackapplication.model.ListItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor( private val getListItemsUseCase: GetListItemsUseCase) : ViewModel() {
    private val _listItem = MutableStateFlow<List<ListItems>>(emptyList())
    val listItems: StateFlow<List<ListItems>> = _listItem


    fun updateList(category: String) {
        _listItem.value = getListItemsUseCase.getList(category)
    }
}