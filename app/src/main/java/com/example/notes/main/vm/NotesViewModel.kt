package com.example.notes.main.vm

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.repos.NotesRepository
import com.example.notes.room.entities.Note
import javax.inject.Inject

class NotesViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {
    private var notesListLiveData: MediatorLiveData<List<Note>> = MediatorLiveData()
    fun notesListLiveData() = notesListLiveData

    var selectedNote: Note? = null

    fun getAllNotes() {
        val source = notesRepository.fetchAllNotes()
        notesListLiveData.removeSource(source)
        notesListLiveData.addSource(source) { notesList ->
            if (notesList != null) {
                notesListLiveData.value = notesList
            }
        }
    }

    fun addNote(title: String?, description: String?) {
        if (!title.isNullOrEmpty() || !description.isNullOrEmpty())
            notesRepository.addNote(title, description)
    }

    fun deleteNote() {
        notesRepository.deleteNote(selectedNote)
        selectedNote = null
    }
}