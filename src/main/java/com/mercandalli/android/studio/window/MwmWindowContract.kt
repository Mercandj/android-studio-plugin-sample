package com.mercandalli.android.studio.window

interface MwmWindowContract {

    interface UserAction {

        fun onCreate()

        fun onSaveClicked()

        fun onLoadClicked()

        fun onUploadClicked()
    }

    interface Screen {

        fun setTitle(text: String)
    }
}
