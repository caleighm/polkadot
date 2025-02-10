package com.polkadot.daycare.helper.data

import com.polkadot.daycare.helper.data.models.Guardian

import kotlinx.coroutines.flow.Flow
import com.polkadot.daycare.helper.data.local.database.GuardianDao
import javax.inject.Inject

interface GuardianRepository {
    val guardians: Flow<List<Guardian>>

    suspend fun add(guardian: Guardian)
}

class DefaultGuardianRepository @Inject constructor(
    private val guardianDao: GuardianDao
) : GuardianRepository {

    override val guardians = guardianDao.getGuardians()

    override suspend fun add(guardian: Guardian) {
        guardianDao.insertGuardian(guardian)
    }
}
