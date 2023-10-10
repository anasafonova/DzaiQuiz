package com.dzaigames.dzaiquiz.data.database.typeconverters

import androidx.room.TypeConverter
import org.json.JSONArray
import org.json.JSONObject

class JsonMapConverter {
    @TypeConverter
    fun jsonMapFromString(map: String?): Map<String, String>? {
        map ?: return null
        return JSONObject(map).toMap().map { e -> e.key to e.value.toString() }.toMap()
    }

    @TypeConverter
    fun jsonMapToString(map: Map<String, *>?): String? {
        return JSONObject(map).toString()
    }
}

fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
    when (val value = this[it])
    {
        is JSONArray ->
        {
            val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
            JSONObject(map).toMap().values.toList()
        }
        is JSONObject -> value.toMap()
        JSONObject.NULL -> null
        else            -> value
    }
}