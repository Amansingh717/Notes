package com.example.notes.di.component.recycler

import androidx.fragment.app.Fragment
import com.example.notes.di.modules.main.recycler.ListNotesRecyclerBinderModule
import dagger.Component

@Component(modules = [ListNotesRecyclerBinderModule::class])
interface ListNotesRecyclerComponent {
    fun inject(fragment: Fragment)
    fun notesRecyclerFactory(): ListNotesRecyclerComponent
}