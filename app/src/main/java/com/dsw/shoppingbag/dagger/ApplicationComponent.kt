package com.dsw.shoppingbag.dagger

import com.dsw.shoppingbag.MainApplication
import com.dsw.shoppingbag.db.DbManagerImp
import com.dsw.shoppingbag.network.RetrofitBuilder
import com.dsw.shoppingbag.view.activities.MainActivity
import com.dsw.shoppingbag.viewmodel.ShoppingBagViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * This component tells Dagger about the Activities/Fragments that requests injection
 */
@Singleton
@Component(modules = [RetrofitBuilder::class, AndroidModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(dbManagerImp: DbManagerImp)

    fun inject(shoppingBagViewModel: ShoppingBagViewModel)

}