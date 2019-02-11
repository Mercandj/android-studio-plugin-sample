package com.mercandalli.android.studio.toast

class ToastModule {

    fun createToastManager(): ToastManager {
        return ToastManagerImpl()
    }
}
