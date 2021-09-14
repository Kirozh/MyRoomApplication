package com.example.kirozh.myroomapplication.data_base

import androidx.room.TypeConverter
import java.util.*
import kotlin.Unit.toString

/**
 * @author Kirill Ozhigin on 03.09.2021
 */
class ContactTypeConverters {
    @TypeConverter
    fun toUUID(uuid: String?):UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?):String?{
        return uuid?.toString()
    }
}