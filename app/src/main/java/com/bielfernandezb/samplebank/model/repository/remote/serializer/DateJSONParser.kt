package com.bielfernandezb.samplebank.model.repository.remote.serializer

import android.util.Log
import com.google.gson.*
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateJSONParser : JsonDeserializer<Date?>, JsonSerializer<Date?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date? {
        return try {

            //2018-02-01T00:00:00+01:00
            val jsonString = json.toString().replace("T", " ").replace("Z", "").replace("\"", "")

            // 2018-02-01 00:00:00+01:00
            Log.i(DateJSONParser::class.java.simpleName, "json: $jsonString")
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT)
            val date: Date = format.parse(jsonString)
            Log.i(DateJSONParser::class.java.simpleName, "object: $date")

            // 2018-02-01 00:00:00
            date
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun serialize(
        date: Date?,
        type: Type?,
        jsonSerializationContext: JsonSerializationContext?
    ): JsonElement {
        val dateStr: String
        dateStr = try {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT)
            format.format(date)
        } catch (e: Exception) {
            ""
        }
        return JsonPrimitive(dateStr)
    }
}