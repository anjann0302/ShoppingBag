package com.dsw.shoppingbag.db.model

import androidx.room.Embedded
import java.io.Serializable

/**
 * Database Model class for Shopping bag summary
 */
class ShoppingBagSummaryModel: Serializable {
    @Embedded
    var dbShoppingBagSummary: DBShoppingBagSummary? = null
}