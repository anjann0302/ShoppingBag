package com.dsw.shoppingbag.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsw.shoppingbag.db.util.DbConstants

/**
 * Shopping bag Summary entity class
 */
@Entity(tableName = DbConstants.TABLE_NAME_SUMMARY)
data class DBShoppingBagSummary(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbConstants.SUMMARY_COLUMN_NAME_SUBTOTAL) var subTotal: String?,
    @ColumnInfo(name = DbConstants.SUMMARY_COLUMN_NAME_TAX) var tax: String?,
    @ColumnInfo(name = DbConstants.SUMMARY_COLUMN_NAME_DISCOUNTS) var discounts: String?,
    @ColumnInfo(name = DbConstants.SUMMARY_COLUMN_NAME_TOTAL) var total: String?
)