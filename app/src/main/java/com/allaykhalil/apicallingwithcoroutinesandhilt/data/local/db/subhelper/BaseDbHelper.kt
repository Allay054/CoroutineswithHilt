package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.subhelper

import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.AppDatabase

abstract class BaseDbHelper {
    protected var mAppDatabase: AppDatabase? = null
}