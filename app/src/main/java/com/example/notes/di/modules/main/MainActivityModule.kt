package com.example.notes.di.modules.main

import com.example.notes.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class, MainViewModelModule::class])
    abstract fun mainActivity(): MainActivity
}