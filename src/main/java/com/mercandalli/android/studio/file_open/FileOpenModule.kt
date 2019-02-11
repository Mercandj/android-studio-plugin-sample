package com.mercandalli.android.studio.file_open

import com.mercandalli.android.studio.main.ApplicationGraph

class FileOpenModule {

    fun createFileOpenManager(): FileOpenManager {
        val toastManager = ApplicationGraph.getToastManager()
        return FileOpenManagerImpl(
            toastManager
        )
    }
}
