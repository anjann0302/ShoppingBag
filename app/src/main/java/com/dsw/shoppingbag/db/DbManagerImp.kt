package com.dsw.shoppingbag.db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dsw.shoppingbag.db.dao.ShoppingBagProductsDao
import com.dsw.shoppingbag.db.dao.ShoppingBagPromosDao
import com.dsw.shoppingbag.db.dao.ShoppingBagSummaryDao
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.db.model.ShoppingBagPromosModel
import com.dsw.shoppingbag.db.model.ShoppingBagSummaryModel
import com.dsw.shoppingbag.model.ShoppingBagModel
import javax.inject.Inject

/**
 * Database Manager class which saves and fetches data from Room
 */
class DbManagerImp : DbManager {
    lateinit var mAppDatabase: AppDatabase
    lateinit var mShoppingBagProductsDao: ShoppingBagProductsDao
    lateinit var mShoppingBagPromosDao: ShoppingBagPromosDao
    lateinit var mShoppingBagSummaryDao: ShoppingBagSummaryDao

    @Inject
    constructor(application: Application) {
        mAppDatabase = AppDatabase.Companion.getAppDatabase(application)
        mShoppingBagProductsDao = mAppDatabase.shoppingBagProductsDao()
        mShoppingBagPromosDao = mAppDatabase.shoppingBagPromosDao()
        mShoppingBagSummaryDao = mAppDatabase.shoppingBagSummaryDao()
    }

    override val shoppingBagProducts: LiveData<List<ShoppingBagProductsModel>>?
        get() = mShoppingBagProductsDao.getShoppingBagProducts()
    override val shoppingBagPromos: LiveData<List<ShoppingBagPromosModel>>?
        get() = mShoppingBagPromosDao.getShoppingBagPromos()
    override val shoppingBagSummary: MutableLiveData<ArrayList<ShoppingBagSummaryModel>>?
        get() = mShoppingBagSummaryDao.getShoppingBagSummary()


     fun saveShoppingBagDetails (shoppingBagDetails: ShoppingBagModel) {
         shoppingBagDetails.dbShoppingProductsList.let {
             if (it != null) {
                 mShoppingBagProductsDao.insert(it)
             }
         }

         shoppingBagDetails.dbShoppingPromosList.let {
             if(it!=null) {
                 mShoppingBagPromosDao.insert(it)
             }
         }

         shoppingBagDetails.dbShoppingSummary?.let { mShoppingBagSummaryDao.insert(it) }
    }


}