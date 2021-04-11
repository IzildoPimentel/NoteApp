package com.example.noteapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table ORDER BY note ASC")
    fun getNoteList(): Flow<List<Note>>

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()
}