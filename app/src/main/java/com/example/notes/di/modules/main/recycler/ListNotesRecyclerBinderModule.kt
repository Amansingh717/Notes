package com.example.notes.di.modules.main.recycler

import androidx.fragment.app.Fragment
import com.example.notes.main.ui.ListNotesFragment
import dagger.Binds
import dagger.Module

@Module
interface ListNotesRecyclerBinderModule {
    @Binds
    fun bindListNotesFragment(fragment: ListNotesFragment): Fragment
}