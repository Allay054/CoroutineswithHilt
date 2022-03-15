package com.allaykhalil.apicallingwithcoroutinesandhilt.managers

import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.DbHelper
import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.ResourceProvider
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val appService: ApiService,
    /*,
    private val preferencesHelper: PreferencesHelper,*/
      private val dbHelper: DbHelper
) : DataManager {

    override fun getResourceManager(): ResourceProvider {
        return resourceProvider
    }

    override fun getApiHelper(): ApiService {
        return appService
    }

    override fun getDbHelper(): DbHelper {
        return dbHelper
    }
  /*  override fun getPreferencesHelper(): PreferencesHelper {
       return  preferencesHelper
    }*/
}