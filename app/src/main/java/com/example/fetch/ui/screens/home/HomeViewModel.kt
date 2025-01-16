package com.example.fetch.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetch.base.UiState
import com.example.fetch.domain.model.Item
import com.example.fetch.domain.repository.ItemRepository
import com.example.fetch.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getItemsUseCase: GetItemsUseCase):ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Map<Int, List<Item>>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                getItemsUseCase.invoke().collect { items ->
                    _uiState.value = UiState.Success(items)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    fun retry() {
        loadItems()
    }

}