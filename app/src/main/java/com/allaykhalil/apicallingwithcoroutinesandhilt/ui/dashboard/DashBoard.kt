package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityDashBoardBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.BuyListingActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.viewModel.DashboardViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.CallListingActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.SellActivity

class DashBoard : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding

    private val viewModel: DashboardViewModel by viewModels()

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
                    return DashboardViewModel(this@DashBoard) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)
        binding.apply {
            lifecycleOwner = this@DashBoard
            viewModel = this@DashBoard.viewModel

            fetchCallListing = View.OnClickListener {
                goToCallListing()
            }

            fetchBuyListing = View.OnClickListener {
                goToBuyListing()
            }

            fetchSellListing=View.OnClickListener {
                goToSellListing()
            }
        }

    }

    private fun goToCallListing() {
        val intent = Intent(this@DashBoard, CallListingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToBuyListing() {
        val intent = Intent(this@DashBoard, BuyListingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToSellListing() {
        val intent = Intent(this@DashBoard, SellActivity::class.java)
        startActivity(intent)
        finish()
    }


}

