package com.allaykhalil.apicallingwithcoroutinesandhilt.managers

import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.DbHelper
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.remote.ApiService
import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.ResourceProvider

interface DataManager {
    fun getApiHelper(): ApiService
    fun getResourceManager(): ResourceProvider
    fun getDbHelper(): DbHelper
}