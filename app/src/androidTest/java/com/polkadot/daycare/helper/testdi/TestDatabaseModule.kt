package com.polkadot.daycare.helper.testdi

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import com.polkadot.daycare.helper.data.StudentRepository
import com.polkadot.daycare.helper.data.di.DataModule
import com.polkadot.daycare.helper.data.di.FakeStudentRepository

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface FakeDataModule {

    @Binds
    abstract fun bindRepository(
        fakeRepository: FakeStudentRepository
    ): StudentRepository
}
