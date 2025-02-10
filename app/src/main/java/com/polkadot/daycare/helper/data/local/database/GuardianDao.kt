package com.polkadot.daycare.helper.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface GuardianDao {
    @Query("SELECT * FROM guardians ORDER BY id DESC LIMIT 10")
    fun getGuardians(): Flow<List<Guardian>>

    @Query("SELECT * FROM guardians WHERE id = :id")
    fun getGuardian(id: Int): Flow<Guardian>

    @Query("SELECT * FROM students WHERE guardianId = :guardianId ORDER BY nickname")
    fun getStudentsOfGuardian(guardianId: Int): Flow<List<Student>>

    @Insert
    suspend fun insertGuardian(guardian: Guardian)
}
