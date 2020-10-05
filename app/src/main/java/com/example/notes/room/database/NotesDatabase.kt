package com.example.notes.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.room.dao.NotesDao
import com.example.notes.room.entities.Note

@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        private const val DB_NAME = "NotesDb"

        @Volatile
        private var instance: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NotesDatabase {
            return Room.databaseBuilder(context, NotesDatabase::class.java, DB_NAME)
                .build()
        }
    }
}