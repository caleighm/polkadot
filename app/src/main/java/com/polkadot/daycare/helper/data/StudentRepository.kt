package com.polkadot.daycare.helper.data

import kotlinx.coroutines.flow.Flow
import com.polkadot.daycare.helper.data.local.database.StudentDao
import com.polkadot.daycare.helper.data.models.Student
import javax.inject.Inject

interface StudentRepository {
    val students: Flow<List<Student>>

    suspend fun add(student: Student)
}

class DefaultStudentRepository @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {

    override val students = studentDao.getStudents()

    override suspend fun add(student: Student) {
        studentDao.insertStudent(student)
    }
}
