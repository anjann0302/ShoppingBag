package com.dsw.shoppingbag.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dsw.shoppingbag.db.dao.ShoppingBagProductsDao
import com.dsw.shoppingbag.db.dao.ShoppingBagPromosDao
import com.dsw.shoppingbag.db.dao.ShoppingBagSummaryDao
import com.dsw.shoppingbag.db.model.DBShoppingBagProducts
import com.dsw.shoppingbag.db.model.DBShoppingBagPromos
import com.dsw.shoppingbag.db.model.DBShoppingBagSummary
import com.dsw.shoppingbag.db.util.DbConstants

/**
 * Room Database class which creates instance for the RoomDatabase
 */
@Database(
    entities = [DBShoppingBagProducts::class, DBShoppingBagPromos::class,
        DBShoppingBagSummary::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingBagProductsDao(): ShoppingBagProductsDao
    abstract fun shoppingBagPromosDao(): ShoppingBagPromosDao
    abstract fun shoppingBagSummaryDao(): ShoppingBagSummaryDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DbConstants.DATABASE_NAME_CONTACTS
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE!!
        }
    }
}