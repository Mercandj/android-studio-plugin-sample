package com.mercandalli.android.studio.dialog

import com.intellij.openapi.ui.Messages

class DialogManagerImpl : DialogManager {

    override fun showErrorDialog(
            message: String,
            title: String
    ) {
        Messages.showErrorDialog(message, title)
    }
}