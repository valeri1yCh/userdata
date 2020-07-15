package org.bloodwyn.userdata.data.local

import androidx.room.TypeConverter
import org.bloodwyn.userdata.data.local.DbUser.Gender
import java.lang.StringBuilder
import java.util.*

class DbUserConverter {

    @TypeConverter
    fun fromEnumToString(gender: Gender): String {
        return gender.name
    }

    @TypeConverter
    fun fromStringToEnum(gender: String): DbUser.Gender {
        return Gender.valueOf(gender)
    }

    @TypeConverter
    fun fromCalendarToString(birthDate: Calendar): String {
        val sb = StringBuilder()
        sb.append(birthDate.get(Calendar.YEAR))
        sb.append("-")
        sb.append(Calendar.MONTH)
        sb.append("-")
        sb.append(Calendar.DAY_OF_MONTH)

        return sb.toString()
    }

    @TypeConverter
    fun fromStringToCalendar(birthDate: String): Calendar {
        val fields = birthDate.split("-")
        val calendar = Calendar.getInstance()
        calendar.set(fields[0].toInt(), fields[1].toInt(), fields[2].toInt())

        return calendar
    }
}
