package br.com.studyroyale

import androidx.room.*
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "atividade")
class Atividade: Serializable {

    @PrimaryKey
    var id:Long = 0
    var professor = ""
    var nota = 0
    var disciplina = ""
    var nome = ""
    var foto = "" // helper para aluno
    //@Embedded
    @TypeConverters(RoomConverter::class)
    //@Ignore
    var alunos = mutableListOf<Aluno>()

    override fun toString(): String {
        return "$disciplina - $nome \n Professor: $professor"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}