package br.com.studyroyale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(Atividade::class), version = 5)
abstract class StudyRoyaleDatabase:RoomDatabase() {
    abstract fun atividadeDAO(): AtividadeDAO
}