package com.allaykhalil.apicallingwithcoroutinesandhilt.di.module

import android.content.Context
import androidx.room.Room
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.AppDatabase
import com.allaykhalil.apicallingwithcoroutinesandhilt.di.DatabaseInfo
import com.allaykhalil.apicallingwithcoroutinesandhilt.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return Constants.DB_NAME
    }

}
