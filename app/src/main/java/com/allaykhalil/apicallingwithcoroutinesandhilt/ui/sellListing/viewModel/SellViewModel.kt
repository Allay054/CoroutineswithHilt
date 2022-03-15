package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.SellNavigator
import com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.SellRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SellViewModel @Inject constructor(var sellRepository: SellRepository) :
    BaseViewModel<SellNavigator>(sellRepository.dataManager) {
    val contactList = MutableLiveData<List<ItemSellDbModel>>()
    val observableArrayList = ObservableArrayList<ItemSellDbModel>()

    fun fetchFromDb() {
        if (observableArrayList.size > 0)
            observableArrayList.clear()

        viewModelScope.launch {
            sellRepository.fetchContactsFromDb().run {
                /*
                * Add a small delay to reflect the changes on the UI
                */
                delay(5)
                if (this != null) {
                    if (this.isNotEmpty()) {
                        contactList.value = this
                        //       getNavigator()?.showSuccessMessage("found")
                    } else {
                        getNavigator()?.showSuccessMessage("No Items Found,Please add new")
                    }
                } else {
                    getNavigator()?.showSuccessMessage("null")
                }
            }
        }
    }

    fun saveToDbClick(
        id: Int, name: String, price: String, quantity: Int, type: Int
    ) {
        viewModelScope.launch {
            saveRecordsToDb(id, name, price, quantity, type)
        }
    }


    private fun resetData() {
        /*
        * Function to reset data back to View in case Api call fails
        */
        contactList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }
    }

    private fun saveRecordsToDb(id: Int, name: String, price: String, quantity: Int, type: Int) {
        val contactsModel = ItemSellDbModel(id, name, price, quantity, type)


        contactsModel.let {
            viewModelScope.launch(Dispatchers.IO) {
                dataManager.getDbHelper().insertContacts(it)
                fetchFromDb()

            }
        }
    }
}