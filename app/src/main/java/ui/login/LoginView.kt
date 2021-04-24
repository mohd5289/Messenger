package ui.login

import com.example.messenger.messenger.auth.AuthView

interface LoginView:AuthView, BaseView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToSignUp()
    fun navigateToHome()

}