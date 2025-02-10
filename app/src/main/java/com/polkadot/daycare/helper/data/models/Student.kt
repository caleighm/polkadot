package com.polkadot.daycare.helper.data.models

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "students",
    foreignKeys = [
        ForeignKey(entity = Guardian::class, parentColumns = ["id"], childColumns = ["guardianId"])
    ],
    indices = [Index("guardianId")]
)
data class Student(
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val birthday: Date,
    val guardianId: Int,
    val houseNumber: String,
    val streetName: String,
    val city: String,
    val province: String,
    val postalCode: String,
    val allergies: String,
    @DrawableRes val imageId: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
