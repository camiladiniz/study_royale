package br.com.studyroyale

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AtividadeDAO {
    @Query("SELECT * FROM atividade where id = :id")
    fun getById(id: Long): Atividade?

    @Query("SELECT * FROM atividade")
    fun findAll(): List<Atividade>

    @Insert
    fun insert(atividade: Atividade)

    @Delete
    fun delete(atividade: Atividade)

}