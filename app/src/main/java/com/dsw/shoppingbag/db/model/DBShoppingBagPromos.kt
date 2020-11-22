package com.dsw.shoppingbag.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsw.shoppingbag.db.util.DbConstants

/**
 * Shopping bag promos entity class
 */
@Entity(tableName = DbConstants.TABLE_NAME_PROMOS)
data class DBShoppingBagPromos(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbConstants.PROMOS_COLUMN_NAME_CODE) var code: String?,
    @ColumnInfo(name = DbConstants.PROMOS_COLUMN_NAME_DESCRIPTION) var description: String?,
    @ColumnInfo(name = DbConstants.PROMOS_COLUMN_NAME_VALUE) var value: String?
)

