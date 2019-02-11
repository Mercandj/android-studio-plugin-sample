package com.mercandalli.android.studio.dialog

class DialogModule {

    fun createErrorManager(): DialogManager {
        return DialogManagerImpl()
    }
}