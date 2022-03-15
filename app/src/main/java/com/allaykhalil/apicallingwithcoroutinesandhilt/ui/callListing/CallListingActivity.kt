package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing

import android.content.Intent
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivityCallListingBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.adapters.CallListAdapter
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.viewModel.CallListingViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.DashBoard
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CallListingActivity :
    BaseActivity<CallListingViewModel, ActivityCallListingBinding>(R.layout.activity_call_listing),
    CallListingNavigator {
    @Inject
    lateinit var adapter: CallListAdapter
    override val viewModel: CallListingViewModel by viewModels()
    override fun getBindingVariable() = BR.viewModel
    override fun initUi() {
        viewModel.setNavigator(this)
        bindings.rvContacts.adapter = adapter

        viewModel.allCallList.observe(this,
            {
                viewModel.observableArrayList.addAll(it)
            })

        viewModel.fetchAllCallList()
    }

    override fun onBackPressed() {
        val intent = Intent(this@CallListingActivity, DashBoard::class.java)
        startActivity(intent)
        finish()
    }
}