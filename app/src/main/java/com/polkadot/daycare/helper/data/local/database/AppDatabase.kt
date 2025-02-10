package com.polkadot.daycare.helper.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.polkadot.daycare.helper.data.models.Converters
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.Student

@Database(entities = [Student::class, Guardian::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun guardianDao(): GuardianDao
}
