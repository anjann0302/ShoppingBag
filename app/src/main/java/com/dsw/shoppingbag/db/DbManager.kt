package com.dsw.shoppingbag.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.db.model.ShoppingBagPromosModel
import com.dsw.shoppingbag.db.model.ShoppingBagSummaryModel

/**
 * Interface for maintaining structure of all Query results
 */
interface DbManager {
    val shoppingBagProducts: LiveData<List<ShoppingBagProductsModel>>?

    val shoppingBagPromos: LiveData<List<ShoppingBagPromosModel>>?

    val shoppingBagSummary: MutableLiveData<ArrayList<ShoppingBagSummaryModel>>?
}