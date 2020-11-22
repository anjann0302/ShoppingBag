package com.dsw.shoppingbag.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.dsw.shoppingbag.db.model.DBShoppingBagSummary
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.db.model.ShoppingBagSummaryModel

/**
 * Dao class that manages shopping bag Summary Database operations
 */
@Dao
interface ShoppingBagSummaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shoppingBagSummary: DBShoppingBagSummary)

    @Transaction
    @Query("SELECT * FROM summary")
    fun getShoppingBagSummary(): MutableLiveData<ArrayList<ShoppingBagSummaryModel>>
}