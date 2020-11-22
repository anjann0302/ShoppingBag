package com.dsw.shoppingbag.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsw.shoppingbag.db.util.DbConstants

/**
 * Shopping bag products entity class
 */
@Entity(tableName = DbConstants.TABLE_NAME_PRODUCTS)
data class DBShoppingBagProducts(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbConstants.PRODUCTS_COLUMN_NAME_ID) var id: Long?,
    @ColumnInfo(name = DbConstants.PRODUCT_COLUMN_NAME_SKU) var sku: String?,
    @ColumnInfo(name = DbConstants.PRODUCT_COLUMN_NAME_DISPLAY_NAME) var displayName: String?,
    @ColumnInfo(name = DbConstants.PRODUCT_COLUMN_NAME_PRICE) var price: String?,
    @ColumnInfo(name = DbConstants.PRODUCT_COLUMN_NAME_QUANTITY) var quantity: Int?
)