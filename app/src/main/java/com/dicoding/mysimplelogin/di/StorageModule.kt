package com.dicoding.mysimplelogin.di

import android.content.Context
import com.dicoding.mysimplelogin.SessionManager
import dagger.Module
import dagger.Provides

@Module // untuk membuat module
class StorageModule {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}

// Lalu bagaimana untuk inisialisasi UserRepository? Kita akan melakukan injection pada constructor sehingga tidak perlu di-provide di module ini.