package com.mercandalli.android.studio.on_boarding

import com.mercandalli.android.studio.main.ApplicationGraph
import com.intellij.openapi.project.ProjectManager

class OnBoardingModule {

    private val onBoardingStorage = lazy {
        val project = ProjectManager.getInstance().openProjects[0]
        OnBoardingStorageComponent.getInstance(project)
    }

    fun createOnBoardingManager(): OnBoardingManager {
        val fileOpenManager = ApplicationGraph.getFileOpenManager()
        val networkManager = ApplicationGraph.getNetworkManager()
        return OnBoardingManagerImpl(
            fileOpenManager,
            onBoardingStorage,
            networkManager
        )
    }
}
