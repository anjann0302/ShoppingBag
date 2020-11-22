package com.dsw.shoppingbag.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dsw.shoppingbag.R
import com.dsw.shoppingbag.databinding.ItemProductsBinding
import com.dsw.shoppingbag.db.model.ShoppingBagProductsModel
import com.dsw.shoppingbag.viewmodel.ProductViewModel

/**
 * Adapter class to load the Products List into the MainActivity
 */
class ProductsListAdapter : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    private lateinit var productsList: List<ShoppingBagProductsModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemProductsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_products,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    // Binds the data one by one onto the recyclerview
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    // Returns the count of the list to populate the number of views
    override fun getItemCount(): Int {
        return if (::productsList.isInitialized) productsList.size else 0
    }

    // Method to update data retrived from API to recyclerview
    fun updateProductsList(
        productsList: List<ShoppingBagProductsModel>
    ) {
        this.productsList = productsList
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class used in the Adapter to hold the view reference
     */
    class ViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ProductViewModel()

        fun bind(productInfo: ShoppingBagProductsModel) {
            productInfo.dbShoppingBagProducts?.let { viewModel.bind(it) }
            binding.productViewModel = viewModel
        }
    }

}
