package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.CallListingNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.CallListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CallListingViewModel @Inject constructor(var callListingRepository: CallListingRepository) :
    BaseViewModel<CallListingNavigator>(callListingRepository.dataManager) {
    val allCallList = MutableLiveData<ArrayList<GetCallListingScreen>>()
    val observableArrayList = ObservableArrayList<GetCallListingScreen>()


    fun fetchAllCallList() {

        viewModelScope.launch {
            makeApiCallForCallListing()
            // saveRecordsToDb()
        }
    }

    private suspend fun makeApiCallForCallListing() {
        /* if (contactList. > 0)
             contactList.clear()*/

        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            when (val request = callListingRepository.fetchCallList()) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.let {
                        if (!it.isNullOrEmpty()) {
                            allCallList.value = it
                            //    getNavigator()?.showSuccessMessage("Data Found" + allCallList.value!!.size.toString())
                        } else {
                            getNavigator()?.showErrorMessage("No Data Found")
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
        allCallList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }
    }


}