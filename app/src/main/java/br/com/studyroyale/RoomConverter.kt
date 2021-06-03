package br.com.studyroyale

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


public class RoomConverter {

    @TypeConverter
    fun fromAlunosList(countryLang: List<Aluno?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<Aluno?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toAlunosList(countryLangString: String?): List<Aluno>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<Aluno?>?>() {}.type
        return gson.fromJson<List<Aluno>>(countryLangString, type)
    }
}