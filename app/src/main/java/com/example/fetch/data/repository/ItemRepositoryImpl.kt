package com.example.fetch.data.repository

import com.example.fetch.data.model.ItemResponse
import com.example.fetch.data.service.ApiService
import com.example.fetch.domain.model.Item
import com.example.fetch.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemRepositoryImpl (private val apiService: ApiService): ItemRepository {

    override fun getItems(): Flow<Map<Int, List<Item>>> = flow {
        try {
            val items = apiService.getItems()
                .filter { !it.name.isNullOrBlank() }
                .sortedWith(
                    compareBy<ItemResponse> { it.listId }
                        .thenBy { it.name }
                )
                .groupBy { it.listId }
                .mapValues { (_, items) ->
                    items.map { Item(it.id, it.listId, it.name!!) }
                }
            emit(items)
        } catch (e: Exception) {
            throw e
        }
    }
}