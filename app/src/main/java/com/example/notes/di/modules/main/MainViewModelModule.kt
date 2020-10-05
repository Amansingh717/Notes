package com.example.notes.di.modules.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.di.annotations.ViewModelKey
import com.example.notes.di.factories.ViewModelProviderFactory
import com.example.notes.main.vm.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bind(viewModel: NotesViewModel): ViewModel
}