package com.example.fetch.di

import com.example.fetch.data.repository.ItemRepositoryImpl
import com.example.fetch.data.service.ApiService
import com.example.fetch.domain.repository.ItemRepository
import com.example.fetch.domain.usecase.GetItemsUseCase

fun getItemRepository(apiService: ApiService) = ItemRepositoryImpl(apiService)

fun getItemsUseCase(itemRepository: ItemRepository) = GetItemsUseCase(itemRepository)