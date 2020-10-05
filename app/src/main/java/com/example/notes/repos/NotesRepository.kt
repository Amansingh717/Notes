package com.example.notes.repos

import androidx.lifecycle.LiveData
import com.example.notes.room.dao.NotesDao
import com.example.notes.room.entities.Note
import com.example.notes.utility.AppExecutors
import javax.inject.Inject

class NotesRepository @Inject constructor(private var notesDao: NotesDao) {

    fun fetchAllNotes(): LiveData<List<Note>> {
        return notesDao.getAllNotes()
    }

    fun addNote(title: String?, desc: String?) {
        AppExecutors.diskIO().execute {
            val note = Note(noteTitle = title, noteDesc = desc)
            notesDao.addNote(note)
        }
    }

    fun deleteNote(note: Note?) {
        note?.run {
            AppExecutors.diskIO().execute {
                notesDao.deleteNote(note)
            }
        }
    }
}