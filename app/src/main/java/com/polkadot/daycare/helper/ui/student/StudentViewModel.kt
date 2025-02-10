package com.polkadot.daycare.helper.ui.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.models.GeraldGiraffe
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.ui.student.StudentUiState.Error
import com.polkadot.daycare.helper.ui.student.StudentUiState.Loading
import com.polkadot.daycare.helper.ui.student.StudentUiState.Success
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {

    val uiState: StateFlow<StudentUiState> = studentRepository
        .students.map<List<Student>, StudentUiState>(::Success)
        .catch { emit(Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addStudent(name: String) {
        viewModelScope.launch {
            studentRepository.add(Student( // TODO just use mocked info for now
                firstName = name,
                lastName = GeraldGiraffe.lastName,
                nickname = GeraldGiraffe.nickname,
                birthday = GeraldGiraffe.birthday,
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

sealed interface StudentUiState {
    object Loading : StudentUiState
    data class Error(val throwable: Throwable) : StudentUiState
    data class Success(val data: List<Student>) : StudentUiState
}
