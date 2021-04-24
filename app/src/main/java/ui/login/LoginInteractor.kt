package ui.login

import com.example.messenger.messenger.auth.AuthInteractor
import com.example.messenger.messenger.data.local.AppPreferences

interface LoginInteractor: AuthInteractor {
    interface OnDetailsRetrievalFinishedListener {
        fun onDetailsRetrievalSuccess()
        fun onDetailsRetrievalError()
    }
    fun login(username: String, password: String,
              listener: AuthInteractor.onAuthFinishedListener)

    fun retrieveDetails(preferences: AppPreferences,
                        listener: OnDetailsRetrievalFinishedListener)


}