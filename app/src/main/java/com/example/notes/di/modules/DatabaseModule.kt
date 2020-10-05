package com.example.notes.di.modules

import android.app.Application
import com.example.notes.room.database.NotesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideNotesDatabase(app: Application) = NotesDatabase.getInstance(app)

    @Provides
    @Singleton
    fun provideNotesDao(db: NotesDatabase) = db.notesDao()
}