package com.polkadot.daycare.helper.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guardians")
data class Guardian(
    val name: String,
    val phone: String,
    val email: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}