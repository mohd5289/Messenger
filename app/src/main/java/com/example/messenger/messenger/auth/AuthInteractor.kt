package com.example.messenger.messenger.auth

import com.example.messenger.messenger.data.local.AppPreferences
import com.example.messenger.messenger.data.vo.UserVO

interface AuthInteractor {
    var userDetails: UserVO
    var accessToken: String
    var submittedUsername: String
    var submittedPassword: String
    interface onAuthFinishedListener {
        fun onAuthSuccess()
        fun onAuthError()
        fun onUsernameError()
        fun onPasswordError()
    }
    fun persistAccessToken(preferences: AppPreferences)
    fun persistUserDetails(preferences: AppPreferences)
}