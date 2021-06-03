package br.com.studyroyale

import com.google.gson.GsonBuilder
import java.io.Serializable

class LoginModel: Serializable {

    var ra = ""
    var senha = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}