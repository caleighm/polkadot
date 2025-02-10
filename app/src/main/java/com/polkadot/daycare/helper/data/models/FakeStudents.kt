package com.polkadot.daycare.helper.data.models

import com.polkadot.daycare.helper.R
import java.sql.Date

val PennyWarbler = Student(
    firstName = "Penelope",
    lastName = "Warbler",
    nickname = "Penny",
    birthday = Date.valueOf("2022-10-1"),
    joined = Date.valueOf("2023-9-1"),
    guardianId = PapaWarbler.id,
    houseNumber = "123",
    streetName = "Main St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "Cats",
    imageId = R.drawable.penny_warbler2
)

val GeraldGiraffe = Student(
    firstName = "Gerald",
    lastName = "Giraffe",
    nickname = "GerBear",
    birthday = Date.valueOf("2022-12-1"),
    joined = Date.valueOf("2025-01-5"),
    guardianId = MamaGiraffe.id,
    houseNumber = "234",
    streetName = "Side St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "",
    imageId = R.drawable.gerald_giraffe
)

val LolaLizard = Student(
    firstName = "Lola",
    lastName = "Lizard",
    nickname = "Lola",
    birthday = Date.valueOf("2021-9-1"),
    joined = Date.valueOf("2023-10-5"),
    guardianId = MamaLizard.id,
    houseNumber = "345-1",
    streetName = "Another St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "",
    imageId = R.drawable.lola_lizard
)

fun Student.getBasics(): StudentOverview {
    return StudentOverview(
        firstName = this.firstName,
        lastName = this.lastName,
        nickname = this.nickname,
        birthday = this.birthday,
        imageId = this.imageId,
        id = this.id,
        guardianId = this.guardianId
    )
}

val fakeStudents = listOf(PennyWarbler.getBasics(), GeraldGiraffe.getBasics(), LolaLizard.getBasics())