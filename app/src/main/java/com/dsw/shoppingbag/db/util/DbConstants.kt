package com.dsw.shoppingbag.db.util

/**
 * Database constant class where all the entity details were maintained
 */
object DbConstants {
    const val DATABASE_NAME_CONTACTS = "shopping_bag_database"

    // Table Names
    const val TABLE_NAME_PRODUCTS = "products"
    const val TABLE_NAME_PROMOS = "promos"
    const val TABLE_NAME_SUMMARY = "summary"

    // Products table column details
    const val PRODUCTS_COLUMN_NAME_ID = "id"
    const val PRODUCT_COLUMN_NAME_SKU = "sku"
    const val PRODUCT_COLUMN_NAME_DISPLAY_NAME = "display_name"
    const val PRODUCT_COLUMN_NAME_PRICE = "price"
    const val PRODUCT_COLUMN_NAME_QUANTITY = "quantity"

    // Promos table column details
    const val PROMOS_COLUMN_NAME_CODE = "id"
    const val PROMOS_COLUMN_NAME_DESCRIPTION = "description"
    const val PROMOS_COLUMN_NAME_VALUE = "value"

    // Summary table column details
    const val SUMMARY_COLUMN_NAME_SUBTOTAL = "subtotal"
    const val SUMMARY_COLUMN_NAME_TAX = "tax"
    const val SUMMARY_COLUMN_NAME_DISCOUNTS = "discounts"
    const val SUMMARY_COLUMN_NAME_TOTAL = "total"

}