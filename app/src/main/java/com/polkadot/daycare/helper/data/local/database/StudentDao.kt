package com.polkadot.daycare.helper.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.StudentOverview

@Dao
interface StudentDao {
    @Query("SELECT nickname, id, firstName, lastName, birthday, imageId, guardianId FROM students ORDER BY nickname")
    fun getStudentBasics(): Flow<List<StudentOverview>>

    @Query("SELECT * FROM students WHERE id = :id")
    fun getStudent(id: Int): Flow<Student>

    @Insert
    suspend fun insertStudent(student: Student)
}
