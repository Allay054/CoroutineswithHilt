package com.allaykhalil.apicallingwithcoroutinesandhilt.di

import android.app.Application
import android.content.Context
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.DbHelper
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.DbHelperImpl
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManagerImpl
import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.Constants
import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun providePreferenceName(): String {
        return Constants.PREF_NAME
    }

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context.applicationContext)
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl): DataManager {
        return dataManagerImpl
    }
    @Singleton
    @Provides
    fun provideDbHelper(dbHelperImpl: DbHelperImpl): DbHelper {
        return dbHelperImpl
    }

}