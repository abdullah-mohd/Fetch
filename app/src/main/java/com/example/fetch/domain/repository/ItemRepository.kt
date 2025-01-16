package com.example.fetch.domain.repository

import com.example.fetch.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItems() : Flow<Map<Int, List<Item>>>
}