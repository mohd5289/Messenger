package ui.login

import android.content.Context

interface BaseView {
    fun bindViews()
    fun getContext(): Context
}