package com.example.notes.di.component

import android.app.Application
import com.example.notes.NotesApplication
import com.example.notes.di.modules.DatabaseModule
import com.example.notes.di.modules.ViewModelFactoryModule
import com.example.notes.di.modules.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        MainActivityModule::class,
        DatabaseModule::class,
        ViewModelFactoryModule::class]
)
interface ApplicationComponent : AndroidInjector<NotesApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}