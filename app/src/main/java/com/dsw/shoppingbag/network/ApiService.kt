package com.dsw.shoppingbag.network

import com.dsw.shoppingbag.model.ShoppingBagModel
import retrofit2.http.GET

/**
 * GET network API call to get shopping bag data from the API
 */
interface ApiService {
    @GET("bag")
    suspend fun getBagDetails(): ShoppingBagModel

}