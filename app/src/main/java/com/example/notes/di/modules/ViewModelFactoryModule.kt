package com.example.notes.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.notes.di.factories.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}