package com.polkadot.daycare.helper.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.polkadot.daycare.helper.data.local.database.AppDatabase
import com.polkadot.daycare.helper.data.local.database.GuardianDao
import com.polkadot.daycare.helper.data.local.database.StudentDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideStudentDao(appDatabase: AppDatabase): StudentDao {
        return appDatabase.studentDao()
    }

    @Provides
    fun provideGuardianDao(appDatabase: AppDatabase): GuardianDao {
        return appDatabase.guardianDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Student"
        ).build()
    }
}
