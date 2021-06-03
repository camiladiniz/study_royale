package br.com.studyroyale

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AtividadeService {

    val host = "http://camiladiniz.pythonanywhere.com"
    val TAG = "WS_study_royale"

    fun getAtividades (context: Context): List<Atividade> {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/atividades"
            val json = HttpHelper.get(url)

            //Log.d(TAG, json)
           return parserJson(json)
        } else {
           return ArrayList<Atividade>()
        }

//        val disciplinas = mutableListOf<Atividade>()
//
////         cria 5 atividades
//        val d1 = Atividade()
//        d1.id = 1
//        d1.disciplina = "Qualidade de Software"
//        d1.nome = "Teste de Software"
//        d1.nota = 8
//        d1.professor = ""
//        d1.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
//        disciplinas.add(d1)
//
//        val d2 = Atividade()
//        d2.id = 1
//        d2.disciplina = "OPE"
//        d2.nome = "Primeiro CRUD"
//        d2.nota = 7
//        d2.professor = "Vitor Williams"
//        d2.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
//        disciplinas.add(d2)
//
//        val d3 = Atividade()
//        d3.id = 1
//        d3.disciplina = "Internet das Coisas"
//        d3.nome = "Automação"
//        d3.nota = 4
//        d3.professor = "Leonardo Bontempo"
//        d3.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
//        disciplinas.add(d3)
//
//        val d4 = Atividade()
//        d4.id = 1
//        d4.disciplina = "Dispositivos Móveis"
//        d4.nome = "Tela de Login"
//        d4.nota = 9
//        d4.professor = "Fernando Sequeira"
//        d4.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
//        disciplinas.add(d4)
//
//        val d5 = Atividade()
//        d5.id = 1
//        d5.disciplina = "Arquitetura"
//        d5.nome = "Prova de Conceito"
//        d5.nota = 10
//        d5.professor = "Antonio de Oliveira"
//        d5.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
//        disciplinas.add(d5)
//
//
//        return disciplinas
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}