package br.com.studyroyale

class Aluno {

    var id:Long = 0
    var nome = ""
    var nota = ""
    var ra = ""
    var foto = ""

    override fun toString(): String {
        return "$nome - Nota: $nota"
    }

}