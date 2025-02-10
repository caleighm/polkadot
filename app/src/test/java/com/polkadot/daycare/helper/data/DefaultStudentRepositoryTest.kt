package com.polkadot.daycare.helper.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.polkadot.daycare.helper.data.local.database.StudentDao
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.fakeStudents

/**
 * Unit tests for [DefaultStudentRepository].
 */
class DefaultStudentRepositoryTest {

    @Test
    fun students_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultStudentRepository(FakeStudentDao())

        repository.add(fakeStudents.first())

        assertEquals(repository.students.first().size, 1)
    }

}

private class FakeStudentDao : StudentDao {

    private val data = mutableListOf<Student>()

    override fun getStudents(): Flow<List<Student>> = flow {
        emit(data)
    }

    override fun getStudentsOfGuardian(guardianId: Int) = flow {
        emit(data)
    }

    override suspend fun insertStudent(student: Student) {
        data.add(0, student)
    }
}
