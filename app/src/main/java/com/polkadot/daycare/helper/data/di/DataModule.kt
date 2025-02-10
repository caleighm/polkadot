package com.polkadot.daycare.helper.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.DefaultStudentRepository
import com.polkadot.daycare.helper.data.models.Guardian
import com.polkadot.daycare.helper.data.models.PapaWarbler
import com.polkadot.daycare.helper.data.models.PennyWarbler
import com.polkadot.daycare.helper.data.models.Student
import com.polkadot.daycare.helper.data.models.StudentOverview
import com.polkadot.daycare.helper.data.models.fakeGuardians
import com.polkadot.daycare.helper.data.models.fakeStudents
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsStudentRepository(
        studentRepository: DefaultStudentRepository
    ): StudentRepository
}

class FakeStudentRepository @Inject constructor() : StudentRepository {
    override val students: Flow<List<StudentOverview>> = flowOf(fakeStudents)
    override val guardians: Flow<List<Guardian>> = flowOf(fakeGuardians)

    override suspend fun add(student: Student) {
        throw NotImplementedError()
    }

    override suspend fun add(guardian: Guardian) {
        throw NotImplementedError()
    }

    override fun getStudent(id: Int): Flow<Student> {
        return flowOf(PennyWarbler)
    }

    override fun getGuardian(id: Int): Flow<Guardian> {
        return flowOf(PapaWarbler)
    }
}
