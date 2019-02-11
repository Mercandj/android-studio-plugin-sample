package com.mercandalli.android.studio.on_boarding

import com.mercandalli.android.studio.main.ApplicationGraph

class OnBoardingModule {

    fun createOnBoardingManager(): OnBoardingManager {
        val fileOpenManager = ApplicationGraph.getFileOpenManager()
        return OnBoardingManagerImpl(
            fileOpenManager
        )
    }
}
