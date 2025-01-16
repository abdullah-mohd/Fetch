package com.example.fetch.domain.usecase

import com.example.fetch.data.model.ItemResponse
import com.example.fetch.domain.model.Item
import com.example.fetch.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetItemsUseCase (private val itemRepository: ItemRepository) {

    suspend fun invoke(): Flow<Map<Int, List<Item>>> {
        try {
            val items = itemRepository.getItems().filter { !it.name.isNullOrBlank() }
                .sortedWith(
                    compareBy<ItemResponse> { it.listId }
                        .thenBy { it.name }
                )
                .groupBy { it.listId }
                .mapValues { (_, items) ->
                    items.map { Item(it.id, it.listId, it.name!!) }
                }

            return flow { emit(items) }
        }catch (e:Exception){
            throw e
        }
    }

}