package com.polkadot.daycare.helper.data

import com.polkadot.daycare.helper.data.local.database.GuardianDao
import kotlinx.coroutines.flow.Flow
import com.polkadot.daycare.helper.data.local.database.StudentDao
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.StudentOverview
import com.polkadot.daycare.helper.data.network.NetworkDataSource
import javax.inject.Inject

interface GuardianRepository {
    val guardians: Flow<List<Guardian>>

    suspend fun add(guardian: Guardian)

    fun getGuardian(id: Int): Flow<Guardian>
}

interface StudentRepository : GuardianRepository {
    val students: Flow<List<StudentOverview>>

    suspend fun add(student: Student)

    fun getStudent(id: Int): Flow<Student>
}

class DefaultStudentRepository @Inject constructor(
    private val studentDao: StudentDao,
    private val guardianDao: GuardianDao,
    private val networkSource: NetworkDataSource,
) : StudentRepository {

    override val students = studentDao.getStudentBasics()

    override suspend fun add(student: Student) {
        studentDao.insertStudent(student)
    }

    override fun getStudent(id: Int): Flow<Student> {
        return studentDao.getStudent(id)
    }

    override val guardians = guardianDao.getGuardians()

    override suspend fun add(guardian: Guardian) {
        guardianDao.insertGuardian(guardian)
    }

    override fun getGuardian(id: Int): Flow<Guardian> {
        return guardianDao.getGuardian(id)
    }
}
