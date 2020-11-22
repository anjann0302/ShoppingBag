package com.dsw.shoppingbag.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dsw.shoppingbag.R
import com.dsw.shoppingbag.databinding.ItemPromosBinding
import com.dsw.shoppingbag.db.model.ShoppingBagPromosModel
import com.dsw.shoppingbag.viewmodel.PromoViewModel

/**
 * Adapter class to load the Promos List into the MainActivity
 */
class PromosListAdapter : RecyclerView.Adapter<PromosListAdapter.ViewHolder>() {

    private lateinit var promosList: List<ShoppingBagPromosModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPromosBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_promos,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    // Binds the data one by one onto the recyclerview
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(promosList[position])
    }

    // Returns the count of the list to populate the number of views
    override fun getItemCount(): Int {
        return if (::promosList.isInitialized) promosList.size else 0
    }

    // Method to update data retrived from API to recyclerview
    fun updatePromosList(
        promosList: List<ShoppingBagPromosModel>
    ) {
        this.promosList = promosList
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class used in the Adapter to hold the view reference
     */
    class ViewHolder(private val binding: ItemPromosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PromoViewModel()

        fun bind(promosInfo: ShoppingBagPromosModel) {
            promosInfo.dbShoppingBagPromos?.let { viewModel.bind(it) }
            binding.promoViewModel = viewModel
        }
    }

}
