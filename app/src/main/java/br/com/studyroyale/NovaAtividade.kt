package br.com.studyroyale

import com.google.gson.GsonBuilder
import java.io.Serializable

class NovaAtividade: Serializable {

    var id:Long = 0
    var nota = 0
    var foto = ""
    var nome = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}