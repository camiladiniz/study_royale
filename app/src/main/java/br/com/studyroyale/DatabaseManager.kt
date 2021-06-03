package br.com.studyroyale

import androidx.room.Room


object DatabaseManager {

    // singleton
    private var dbInstance: StudyRoyaleDatabase
    init {
        val appContext = StudyRoyaleApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            StudyRoyaleDatabase::class.java, // Referência da classe do banco
            "lms.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getAtividadeDAO(): AtividadeDAO {
        return dbInstance.atividadeDAO()
    }
}