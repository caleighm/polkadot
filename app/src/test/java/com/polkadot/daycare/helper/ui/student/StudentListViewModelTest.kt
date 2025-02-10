package com.polkadot.daycare.helper.ui.student

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.models.Student

class StudentListViewModelTest {
    @Test
    fun uiState_initiallyLoading() = runTest {
        val viewModel = StudentListViewModel(FakeStudentRepository())
        assertEquals(viewModel.uiState.first(), StudentUiState.Loading)
    }

    @Test
    fun uiState_onItemSaved_isDisplayed() = runTest {
        val viewModel = StudentListViewModel(FakeStudentRepository())
        assertEquals(viewModel.uiState.first(), StudentUiState.Loading)
    }
}

private class FakeStudentRepository : StudentRepository {

    private val data = mutableListOf<Student>()

    override val students: Flow<List<Student>>
        get() = flow { emit(data.toList()) }

    override suspend fun add(student: Student) {
        data.add(0, student)
    }
}
