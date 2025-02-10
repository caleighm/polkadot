package com.polkadot.daycare.helper.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.polkadot.daycare.helper.data.models.Guardian
import kotlinx.coroutines.flow.Flow

@Dao
interface GuardianDao {
    @Query("SELECT * FROM guardians ORDER BY id DESC LIMIT 10")
    fun getGuardians(): Flow<List<Guardian>>

    @Query("SELECT * FROM guardians WHERE id = :id")
    fun getGuardian(id: String): Guardian

    @Insert
    suspend fun insertGuardian(guardian: Guardian)
}
