package com.polkadot.daycare.helper.data.local.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class Student(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface StudentDao {
    @Query("SELECT * FROM student ORDER BY uid DESC LIMIT 10")
    fun getStudents(): Flow<List<Student>>

    @Insert
    suspend fun insertStudent(item: Student)
}
