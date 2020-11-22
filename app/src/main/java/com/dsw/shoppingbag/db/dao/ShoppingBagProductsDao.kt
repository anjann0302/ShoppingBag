package com.dsw.shoppingbag.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dsw.shoppingbag.db.model.DBShoppingBagProducts
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel

/**
 * Dao class that manages shopping bag products Database operations
 */
@Dao
interface ShoppingBagProductsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shoppingBagProducts: List<DBShoppingBagProducts>)

    @Transaction
    @Query("SELECT * FROM products")
    fun getShoppingBagProducts(): LiveData<List<ShoppingBagProductsModel>>
}