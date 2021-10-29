package com.dicoding.mysimplelogin

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor (private val sesi: SessionManager) { // karena ini hanya bth SessionManager dan class itu dh di dilm module, jadi bisa inject pada Constructpr

//    companion object { // dh gk perlu make ini Bv
//        @Volatile
//        private var instance: UserRepository? = null
//
//        fun getInstance(sesi: SessionManager): UserRepository =
//            instance ?: synchronized(this) {
//                instance ?: UserRepository(sesi)
//            }
//    }

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()

    // cek Singleton
    fun checkInstance() = Log.d("Singleton", "checkInstance: $this")
}