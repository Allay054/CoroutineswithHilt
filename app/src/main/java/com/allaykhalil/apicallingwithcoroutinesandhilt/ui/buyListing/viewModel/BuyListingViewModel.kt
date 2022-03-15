package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetBuyListingScreen
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.BuyListingNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.BuyListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BuyListingViewModel @Inject constructor(var buyListingRepository: BuyListingRepository) :
    BaseViewModel<BuyListingNavigator>(buyListingRepository.dataManager) {
    val allBuyList = MutableLiveData<ArrayList<GetBuyListingScreen>>()
    val observableArrayList = ObservableArrayList<GetBuyListingScreen>()


    fun fetchAllBuyList() {

        viewModelScope.launch {
            makeApiCallForBuyListing()
            // saveRecordsToDb()
        }
    }

    private suspend fun makeApiCallForBuyListing() {
        /* if (contactList. > 0)
             contactList.clear()*/

        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            when (val request = buyListingRepository.fetchBuyList()) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.let {
                        if (!it.isNullOrEmpty()) {
                            allBuyList.value = it
                            //    getNavigator()?.showSuccessMessage("Data Found" + allCallList.value!!.size.toString())
                        } else {
                            getNavigator()?.showSuccessMessage("No Data Found")
                        }
                    }
                }
                is State.Error -> {
                    getNavigator()?.showErrorMessage(request.responseError.errorMessage)
                    getNavigator()?.hideProgressBar()

                    resetData()
                }
            }
        }
    }

    private fun resetData() {
        /*
        * Function to reset data back to View in case Api call fails
        */
        allBuyList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }
    }


}