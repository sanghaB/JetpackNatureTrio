package com.example.datajetpackapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datajetpackapplication.R
import com.example.datajetpackapplication.domain.usecase.GetListItemsUseCase
import com.example.datajetpackapplication.data.model.ListItems
import com.example.datajetpackapplication.domain.enumclass.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListItemsUseCase: GetListItemsUseCase
) : ViewModel() {

    private val _listItem = MutableStateFlow<List<ListItems>>(emptyList())
    val listItems: StateFlow<List<ListItems>> = _listItem

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _isToastShown = MutableStateFlow(false)//
    val isToastShown: StateFlow<Boolean> = _isToastShown

    val filteredList: StateFlow<List<ListItems>> =
        combine(listItems, searchQuery) { items, query ->
            if (query.isEmpty()) {
                _isToastShown.value = false
                return@combine items
            }
            val filtered = items.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.description.contains(query, ignoreCase = true)
            }
            _isToastShown.value = filtered.isEmpty()
            filtered
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())


    fun updateList(category: Category) {
        _listItem.value = getListItemsUseCase.getList(category)
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    private val _images = MutableStateFlow<List<Int>>(emptyList())
    val images: StateFlow<List<Int>> = _images

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    init {
        loadImagesAndCategories()
    }

    private fun loadImagesAndCategories() {
        viewModelScope.launch {
            _images.value = listOf(
                R.drawable.ic_fruits,
                R.drawable.ic_animals,
                R.drawable.ic_flowers
            )
            _categories.value = listOf(Category.FRUITS, Category.ANIMALS, Category.FLOWERS)
        }
    }

}
