package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing

import android.content.Intent
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityBuyListingBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.adapters.BuyListAdapter
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.viewModel.BuyListingViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.DashBoard
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BuyListingActivity :
    BaseActivity<BuyListingViewModel, ActivityBuyListingBinding>(R.layout.activity_buy_listing),
    BuyListingNavigator {
    @Inject
    lateinit var adapter: BuyListAdapter
    override val viewModel: BuyListingViewModel by viewModels()
    override fun getBindingVariable() = BR.viewModel
    override fun initUi() {
        viewModel.setNavigator(this)
        bindings.rvBuyListing.adapter = adapter

        viewModel.allBuyList.observe(this,
            {
                viewModel.observableArrayList.addAll(it)
            })

        viewModel.fetchAllBuyList()
    }

    override fun onBackPressed() {
        val intent = Intent(this@BuyListingActivity, DashBoard::class.java)
        startActivity(intent)
        finish()
    }
}