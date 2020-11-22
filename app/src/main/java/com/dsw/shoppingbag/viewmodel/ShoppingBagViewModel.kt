package com.dsw.shoppingbag.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dsw.shoppingbag.db.DbManagerImp
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.db.model.ShoppingBagPromosModel
import com.dsw.shoppingbag.db.model.ShoppingBagSummaryModel
import com.dsw.shoppingbag.model.ShoppingBagModel
import com.dsw.shoppingbag.network.Resource
import com.dsw.shoppingbag.network.ShoppingBagRepository
import com.dsw.shoppingbag.view.adapters.ProductsListAdapter
import com.dsw.shoppingbag.view.adapters.PromosListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

/**
 * ViewModel to manage Shopping Bag UI related data in a lifecycle conscious way
 */
@Singleton
class ShoppingBagViewModel @Inject constructor(
    private val shoppingBagRepository: ShoppingBagRepository,
    dbManager: DbManagerImp, application: Application
) : AndroidViewModel(application) {

    val shoppingBagModel = MutableLiveData<Resource<ShoppingBagModel>>()

    private var bagProductItemLiveData: LiveData<List<ShoppingBagProductsModel>>?
    private var bagPromoItemLiveData: LiveData<List<ShoppingBagPromosModel>>?
    private var bagSummaryLiveData: MutableLiveData<ArrayList<ShoppingBagSummaryModel>>?

    val productsListAdapter: ProductsListAdapter = ProductsListAdapter()
    val promosListAdapter: PromosListAdapter = PromosListAdapter()

    init {
        bagProductItemLiveData = dbManager.shoppingBagProducts
        bagPromoItemLiveData = dbManager.shoppingBagPromos
        bagSummaryLiveData = dbManager.shoppingBagSummary

        fetchShoppingBagDetails()
        // Set Content to Products RecyclerView
        bagProductItemLiveData?.value?.let { productsListAdapter.updateProductsList(it) }
        // set Content to Promos RecyclerView
        bagPromoItemLiveData?.value?.let {
            promosListAdapter.updatePromosList(it)
        }
    }

    private fun fetchShoppingBagDetails() {
        viewModelScope.launch {
            shoppingBagModel.postValue(Resource.loading(null))
            try {
                val shoppingBagAPI = shoppingBagRepository.getBagDetails()
                shoppingBagModel.postValue(Resource.success(shoppingBagAPI))
            } catch (e: Exception) {
                shoppingBagModel.postValue(Resource.error(null, e.message.toString()))
            }
        }

    }

    fun getSubTotal(): String? {
        return bagSummaryLiveData?.value?.get(0)?.dbShoppingBagSummary?.subTotal
    }

    fun getTax(): String? {
        return bagSummaryLiveData?.value?.get(0)?.dbShoppingBagSummary?.tax
    }

    fun getDiscounts(): String? {
        return bagSummaryLiveData?.value?.get(0)?.dbShoppingBagSummary?.discounts
    }

    fun getTotal(): String? {
        return bagSummaryLiveData?.value?.get(0)?.dbShoppingBagSummary?.total
    }


}