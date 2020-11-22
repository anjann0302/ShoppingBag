package com.dsw.shoppingbag.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsw.shoppingbag.db.model.DBShoppingBagProducts

/**
 * ViewModel class which binds products data to Adapter at run time.
 */
class ProductViewModel: ViewModel() {
    private var productTitle = MutableLiveData<String>()
    private var productPrice = MutableLiveData<String>()
    private var quantity = MutableLiveData<Int>()

    // Method to bind the data to recyclerview element
    fun bind(product: DBShoppingBagProducts) {
        productTitle.value = product.displayName
        productPrice.value = product.price
        quantity.value = product.quantity
    }

    // Method to return the product title
    fun getProductTitle(): MutableLiveData<String> {
        return productTitle
    }

    // Method to return product price
    fun getProductPrice(): MutableLiveData<String> {
        return productPrice
    }

    // Method to return the product quantity
    fun getProductQty(): MutableLiveData<Int> {
        return quantity
    }
}