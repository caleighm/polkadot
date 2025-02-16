package com.polkadot.daycare.helper.ui.enrollment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.models.GeraldGiraffe
import com.polkadot.daycare.helper.data.models.Student
import javax.inject.Inject

@HiltViewModel
class EnrollmentViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {
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
