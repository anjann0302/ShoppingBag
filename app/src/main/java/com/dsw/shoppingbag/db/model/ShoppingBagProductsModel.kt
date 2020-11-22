package com.dsw.shoppingbag.db.model

import androidx.room.Embedded
import java.io.Serializable

/**
 * Database Model class for Shopping bag products
 */
class ShoppingBagProductsModel: Serializable {
    @Embedded
    var dbShoppingBagProducts: DBShoppingBagProducts? = null
}