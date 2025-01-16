package com.example.fetch.domain.repository

import com.example.fetch.data.model.ItemResponse

interface ItemRepository {

    suspend fun getItems() : List<ItemResponse>
}