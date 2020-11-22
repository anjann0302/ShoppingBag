package com.dsw.shoppingbag.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dsw.shoppingbag.db.model.DBShoppingBagProducts
import com.dsw.shoppingbag.db.model.DBShoppingBagPromos
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.db.model.ShoppingBagPromosModel

/**
 * Dao class that manages shopping bag promos Database operations
 */
@Dao
interface ShoppingBagPromosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shoppingBagPromosList: List<DBShoppingBagPromos>)

    @Transaction
    @Query("SELECT * FROM promos")
    fun getShoppingBagPromos(): LiveData<List<ShoppingBagPromosModel>>
}