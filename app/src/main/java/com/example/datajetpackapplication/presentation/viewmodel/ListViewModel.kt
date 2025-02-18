package com.example.datajetpackapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datajetpackapplication.domain.usecase.GetListItemsUseCase
import com.example.datajetpackapplication.model.ListItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListItemsUseCase: GetListItemsUseCase
) : ViewModel() {

    private val _listItem = MutableStateFlow<List<ListItems>>(emptyList())
    val listItems: StateFlow<List<ListItems>> = _listItem

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _isToastShown = MutableStateFlow(false)
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

    fun updateList(category: String) {
        _listItem.value = getListItemsUseCase.getList(category)
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}
