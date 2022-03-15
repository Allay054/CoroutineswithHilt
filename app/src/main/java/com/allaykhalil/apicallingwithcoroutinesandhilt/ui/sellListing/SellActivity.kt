package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing

import android.app.Dialog
import android.content.Intent
import android.text.TextUtils
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.allaykhalil.apicallingwithcoroutinesandhilt.R
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseActivity
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.viewModel.SellViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.BR
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ActivitySellBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.dashboard.DashBoard
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.adapters.SellAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SellActivity : BaseActivity<SellViewModel, ActivitySellBinding>(R.layout.activity_sell),
    SellNavigator {
    @Inject
    lateinit var adapter: SellAdapter
    override val viewModel: SellViewModel by viewModels()
    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        viewModel.setNavigator(this)
        bindings.rvContacts.adapter = adapter
        viewModel.contactList.observe(this,
            {
                viewModel.observableArrayList.addAll(it)
            })


        viewModel.fetchFromDb()


        bindings.btnInsertNew.setOnClickListener {

            val dialog = Dialog(this@SellActivity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.add_data_db)
            val etProductName = dialog.findViewById(R.id.et_ProductName) as EditText
            val etProductQuantity = dialog.findViewById(R.id.et_ProductQuantity) as EditText
            val etProductType = dialog.findViewById(R.id.et_ProductType) as EditText
            val etProductPrice = dialog.findViewById(R.id.et_ProductPrice) as EditText

            val yesBtn = dialog.findViewById(R.id.btn_save) as Button
            val noBtn = dialog.findViewById(R.id.btn_cancel) as Button

            yesBtn.setOnClickListener {

                val strProductName = etProductName.text.toString()
                val strProductPrice = etProductPrice.text.toString()
                val strProductQuantity = etProductQuantity.text.toString()
                val strProductType = etProductType.text.toString()

                when {
                    TextUtils.isEmpty(strProductName) -> {
                        showErrorMessage("Enter Product Name")
                    }
                    TextUtils.isEmpty(strProductPrice) -> {
                        showErrorMessage("Enter Product Price")
                    }
                    TextUtils.isEmpty(strProductQuantity) -> {
                        showErrorMessage("Enter Product Quantity")
                    }
                    TextUtils.isEmpty(strProductType) -> {
                        showErrorMessage("Enter Product Type")
                    }
                    else -> {

                        viewModel.saveToDbClick(
                            adapter.contactList.size + 1,
                            strProductName,
                            strProductPrice,
                            strProductQuantity.toInt(),
                            strProductType.toInt()
                        )

                        dialog.dismiss()
                    }

                }

                //showSuccessMessage(adapter.contactList.size.toString())
                //showSuccessMessage(adapter.contactList[3].name)

            }
            noBtn.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@SellActivity, DashBoard::class.java)
        startActivity(intent)
        finish()
    }
}