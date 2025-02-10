package com.polkadot.daycare.helper.data.models

import androidx.room.TypeConverter
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.Date

class Converters {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}

fun Date.yearsOld(): Int {
    return Calendar.getInstance().get(Calendar.YEAR) - this.year - 1900
}

fun Date.toBirthdayString(): String {
    return "${this.day} ${DateFormatSymbols().months[this.month - 1]} ${this.year + 1900}"
}