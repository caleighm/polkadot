package com.polkadot.daycare.helper.data.models

import androidx.room.TypeConverter
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

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

fun Date.toPrettyString(): String {
    val dateFormat: DateFormat = SimpleDateFormat("d MMMM yyyy", Locale.CANADA)
    return dateFormat.format(this)
}