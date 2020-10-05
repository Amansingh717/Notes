package com.example.notes.di.modules.main

import com.example.notes.main.ui.AddNotesFragment
import com.example.notes.main.ui.ListNotesFragment
import com.example.notes.main.ui.ViewNoteDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun addNotesFragment(): AddNotesFragment

    @ContributesAndroidInjector
    abstract fun listNotesFragment(): ListNotesFragment

    @ContributesAndroidInjector
    abstract fun viewNoteDialogFragment(): ViewNoteDialogFragment
}