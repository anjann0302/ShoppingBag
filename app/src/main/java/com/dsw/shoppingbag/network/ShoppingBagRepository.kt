package com.dsw.shoppingbag.network

import javax.inject.Inject

/**
 * Repository Class which uses apiService for calling remote API calls
 */
class ShoppingBagRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getBagDetails() = apiService.getBagDetails()
}