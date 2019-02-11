package com.mercandalli.android.studio.toast

interface ToastManager {

    fun toast(message: String)

    fun toastError(message: String)
}
