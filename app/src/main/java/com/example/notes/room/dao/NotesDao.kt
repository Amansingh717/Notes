package com.example.notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.room.entities.Note

@Dao
interface NotesDao {
    @Query("Select * from note")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}