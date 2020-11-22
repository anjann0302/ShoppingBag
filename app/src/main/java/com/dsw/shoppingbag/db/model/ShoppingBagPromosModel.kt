package com.dsw.shoppingbag.db.model

import androidx.room.Embedded
import java.io.Serializable

/**
 * Database Model class for Shopping bag promos
 */
class ShoppingBagPromosModel: Serializable {
    @Embedded
    var dbShoppingBagPromos: DBShoppingBagPromos? = null
}