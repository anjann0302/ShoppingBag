package com.dsw.shoppingbag

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.dsw.shoppingbag.db.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShoppingBagProductsDaoTest {

    private lateinit var appDatabase: AppDatabase

    @Before
    fun initDb(){
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().targetContext, AppDatabase::class.java).build()
    }

    @After
    fun closeDb(){
        appDatabase.close()
    }

    @Test
    fun insertShoppingBagProductsInsertData(){
        TODO()
    }

    @Test
    fun getShoppingBagProductsData(){
        TODO()
    }

}