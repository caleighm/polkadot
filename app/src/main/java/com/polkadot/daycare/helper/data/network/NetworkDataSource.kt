package com.polkadot.daycare.helper.data.network

import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.Student

interface NetworkDataSource {

    val students: List<Student>
    val guardians: List<Guardian>

    suspend fun getStudent(id: Int): Student
    suspend fun getGuardian(id: Int): Guardian
}