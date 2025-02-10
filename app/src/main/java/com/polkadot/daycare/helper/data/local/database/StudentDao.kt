package com.polkadot.daycare.helper.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.polkadot.daycare.helper.data.models.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM students ORDER BY nickname")
    fun getStudents(): Flow<List<Student>>

    @Query("SELECT * FROM students WHERE guardianId = :guardianId ORDER BY nickname")
    fun getStudentsOfGuardian(guardianId: Int): Flow<List<Student>>

    @Insert
    suspend fun insertStudent(student: Student)
}
