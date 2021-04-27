package br.com.studyroyale

import java.io.Serializable

class Atividade: Serializable {

    var id:Long = 0
    var nome = ""
    var professor = ""
    var nota = 0
    var materia = ""
    var nomeAtividade = ""
    var foto = ""

    override fun toString(): String {
        return "$materia - $nomeAtividade - Nota: $nota"
    }
}