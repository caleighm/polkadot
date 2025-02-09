package com.polkadot.daycare.helper.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.polkadot.daycare.helper.data.local.database.Student
import com.polkadot.daycare.helper.data.local.database.StudentDao
import javax.inject.Inject

interface StudentRepository {
    val students: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultStudentRepository @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {

    override val students: Flow<List<String>> =
        studentDao.getStudents().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        studentDao.insertStudent(Student(name = name))
    }
}
