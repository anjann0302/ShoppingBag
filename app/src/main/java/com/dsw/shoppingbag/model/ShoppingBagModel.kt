package com.dsw.shoppingbag.model

import com.dsw.shoppingbag.db.model.DBShoppingBagProducts
import com.dsw.shoppingbag.db.model.DBShoppingBagPromos
import com.dsw.shoppingbag.db.model.DBShoppingBagSummary

/*
 * Data class that holds Shopping Bag info
*/
data class ShoppingBagModel(

    val products: List<Products>,
    val promos: List<Promos>,
    val summary: Summary
) {

    val dbShoppingProductsList: List<DBShoppingBagProducts>?
        get() {
            var dbShoppingProductsList = ArrayList<DBShoppingBagProducts>()
            for (product in products) {
                product.dbShoppingBagProducts.let { dbShoppingProductsList.add(it) }
            }
            return dbShoppingProductsList
        }

    val dbShoppingPromosList: List<DBShoppingBagPromos>?
        get() {
            var dbShoppingPromosList = ArrayList<DBShoppingBagPromos>()
            for (promo in promos) {
                promo.dbShoppingBagPromos.let { dbShoppingPromosList.add(it) }
            }
            return dbShoppingPromosList
        }

    val dbShoppingSummary: DBShoppingBagSummary?
        get() {
           return DBShoppingBagSummary(summary.subtotal, summary.tax, summary.discounts, summary.total)
        }
}

data class Products(
    val sku: String,
    val displayName: String,
    val price: String,
    val quantity: Int,
) {
    val dbShoppingBagProducts: DBShoppingBagProducts
        get() {
            return DBShoppingBagProducts(null, sku, displayName, price, quantity)
        }
}

data class Promos(
    val code: String,
    val description: String,
    val value: String
) {
    val dbShoppingBagPromos: DBShoppingBagPromos
        get() {
            return DBShoppingBagPromos(code, description, value)
        }
}

data class Summary(
    val subtotal: String,
    val tax: String,
    val discounts: String,
    val total: String
)
