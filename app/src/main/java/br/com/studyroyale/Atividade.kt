package br.com.studyroyale

import java.io.Serializable

class Atividade: Serializable {

    var id:Long = 0
    var professor = ""
    var nota = 0
    var disciplina = ""
    var nome = ""
    var alunos = mutableListOf<Aluno>()

    override fun toString(): String {
        return "$disciplina - $nome \n Professor: $professor"
    }
}