package com.polkadot.daycare.helper.data.models

import com.polkadot.daycare.helper.R
import java.sql.Date

val PennyWarbler = Student(
    firstName = "Penelope",
    lastName = "Warbler",
    nickname = "Penny",
    birthday = Date.valueOf("2022-10-1"),
    guardianId = PapaWarbler.id,
    houseNumber = "123",
    streetName = "Main St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "Cats",
    imageId = R.drawable.penny_warbler
)

val GeraldGiraffe = Student(
    firstName = "Gerald",
    lastName = "Giraffe",
    nickname = "GerBear",
    birthday = Date.valueOf("2022-12-1"),
    guardianId = MamaGiraffe.id,
    houseNumber = "234",
    streetName = "Side St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "",
    imageId = R.drawable.penny_warbler // TODO find a giraffe
)


val LolaLizard = Student(
    firstName = "Lola",
    lastName = "Lizard",
    nickname = "Lola",
    birthday = Date.valueOf("2021-9-1"),
    guardianId = MamaLizard.id,
    houseNumber = "345-1",
    streetName = "Another St.",
    city = "Kelowna",
    province = "British Columbia",
    postalCode = "1A2 B3C",
    allergies = "",
    imageId = R.drawable.penny_warbler // TODO find a lizard
)

val fakeStudents = listOf(PennyWarbler, GeraldGiraffe, LolaLizard)