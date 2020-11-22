package com.dsw.shoppingbag.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsw.shoppingbag.db.model.DBShoppingBagProducts
import com.dsw.shoppingbag.db.model.DBShoppingBagPromos

/**
 * ViewModel class which binds promos data to Adapter at run time.
 */
class PromoViewModel: ViewModel() {
    private var promoCode = MutableLiveData<String>()
    private var promoDescription = MutableLiveData<String>()
    private var promoValue = MutableLiveData<String>()

    // Method to bind the data to recyclerview element
    fun bind(promo: DBShoppingBagPromos) {
        promoCode.value = promo.code
        promoCode.value = promo.description
        promoCode.value = promo.value
    }

    // Method to return the promoCode
    fun getPromoCode(): MutableLiveData<String> {
        return promoCode
    }

    // Method to return PromoDescription
    fun getPromoDescription(): MutableLiveData<String> {
        return promoDescription
    }

    // Method to return the PromoValue
    fun getPromoValue(): MutableLiveData<String> {
        return promoValue
    }
}