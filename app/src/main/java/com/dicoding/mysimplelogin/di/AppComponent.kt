package com.dicoding.mysimplelogin.di

import android.content.Context
import com.dicoding.mysimplelogin.HomeActivity
import com.dicoding.mysimplelogin.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton // ada karena di dalam object yang di-inject terdapat @Singleton juga.
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory // berfungsi untuk men-generate otomatis semua kode yang dibutuhkan
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent  // untuk memberi context ke semua class Dagger yg membutuhkan
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity) // klo fragment, nama paramnya itu fragment
}