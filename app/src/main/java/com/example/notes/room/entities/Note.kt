package com.example.notes.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    val noteId: Int? = null,

    @ColumnInfo(name = "noteTitle")
    val noteTitle: String? = null,

    @ColumnInfo(name = "noteDesc")
    val noteDesc: String? = null
)