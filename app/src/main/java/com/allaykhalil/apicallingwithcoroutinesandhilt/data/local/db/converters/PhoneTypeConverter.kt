package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.Phone

class PhoneTypeConverter {

    companion object {
        @TypeConverter
        @JvmStatic
        fun toMedia(value: String?): Phone? {
            return value?.let { Gson().fromJson(it, Phone::class.java) }
        }

        @TypeConverter
        @JvmStatic
        fun toString(data: Phone?): String? {
            return data?.let { Gson().toJson(it) }
        }
    }
}