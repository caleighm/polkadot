package com.polkadot.daycare.helper.ui.student

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.models.GeraldGiraffe
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.ui.StudentDetails
import com.polkadot.daycare.helper.ui.student.StudentDetailUiState.Loading
import com.polkadot.daycare.helper.ui.student.StudentDetailUiState.Success
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class StudentDetailViewModel @Inject constructor(
    private val studentRepository: StudentRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val studentId = savedStateHandle.toRoute<StudentDetails>().studentId
    private val guardianId = savedStateHandle.toRoute<StudentDetails>().guardianId

    val uiState = combine(
        studentRepository.getStudent(studentId),
        studentRepository.getGuardian(guardianId)) {
        student, guardian -> Success(student, guardian)
    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addStudent(name: String) {
        viewModelScope.launch {
            studentRepository.add(Student( // TODO just use mocked info for now
                firstName = name,
                lastName = GeraldGiraffe.lastName,
                nickname = GeraldGiraffe.nickname,
                birthday = GeraldGiraffe.birthday,
                joined = GeraldGiraffe.joined,
                guardianId = GeraldGiraffe.guardianId,
                houseNumber = GeraldGiraffe.houseNumber,
                streetName = GeraldGiraffe.streetName,
                city = GeraldGiraffe.city,
                province = GeraldGiraffe.province,
                postalCode = GeraldGiraffe.postalCode,
                allergies = GeraldGiraffe.allergies,
                imageId = GeraldGiraffe.imageId
            ))
        }
    }
}

sealed interface StudentDetailUiState {
    object Loading : StudentDetailUiState
    data class Error(val throwable: Throwable) : StudentDetailUiState
    data class Success(val student: Student, val guardian: Guardian) : StudentDetailUiState
}
