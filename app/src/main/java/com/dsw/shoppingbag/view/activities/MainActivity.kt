package com.dsw.shoppingbag.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsw.shoppingbag.R
import com.dsw.shoppingbag.dagger.DaggerApplicationComponent
import com.dsw.shoppingbag.databinding.ActivityMainBinding
import com.dsw.shoppingbag.utils.Status
import com.dsw.shoppingbag.viewmodel.ShoppingBagViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Home screen where Shopping Bag details were fetched and displayed
 */
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mShoppingBagViewModel: ShoppingBagViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialize Dagger
        DaggerApplicationComponent.builder()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRemoteConfigCacheDetails()
        getBagDetails()
        setUpDataBinding()
    }

    private fun getRemoteConfigCacheDetails() {
        TODO("Get the Cache config details from remote API and update the AppConstants value")
    }

    /**
     * Method to initialize and load databinding
     */
    private fun setUpDataBinding() {
        // Setup databinding for the layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvProducts.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rvProducts.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.HORIZONTAL
            )
        )
        binding.shoppingBagViewModel = mShoppingBagViewModel
    }

    private fun getBagDetails() {
        mShoppingBagViewModel.shoppingBagModel.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    mProgressBar.visibility = View.GONE
                }
                Status.ERROR -> {
                    // Generic error handling in case of API failure or No internet
                    mProgressBar.visibility = View.GONE
                    /* Snackbar.make(
                         rv_leaguesList, R.string.error_generic,
                         Snackbar.LENGTH_INDEFINITE
                     )*/
                }
                Status.LOADING -> {
                    mProgressBar.visibility = View.VISIBLE
                }
            }
        })
    }
}