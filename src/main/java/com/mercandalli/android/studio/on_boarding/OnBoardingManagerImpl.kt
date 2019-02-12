package com.mercandalli.android.studio.on_boarding

import com.intellij.openapi.project.Project
import com.mercandalli.android.studio.file_open.FileOpenManager
import com.mercandalli.android.studio.main.ApplicationGraph
import com.mercandalli.android.studio.network.NetworkManager

class OnBoardingManagerImpl(
    private val fileOpenManager: FileOpenManager,
    private val onBoardingStorage: Lazy<OnBoardingStorage>,
    private val networkManager: NetworkManager
) : OnBoardingManager {

    override fun load(project: Project) {
        fileOpenManager.open(
            "app/src/main/res/layout/activity_main.xml",
            project
        )
        onBoardingStorage.value.increaseNumberOfLoad()
        val numberOfLoadPersisted = onBoardingStorage.value.getNumberOfLoadPersisted()
        ApplicationGraph.getToastManager().toast("OnBoarding loaded ($numberOfLoadPersisted)")
    }

    override fun save(project: Project) {
        ApplicationGraph.getToastManager().toast("TODO\nOnBoarding saved")
    }

    override fun upload(project: Project) {
        Thread(Runnable {
            val response = networkManager.get("http://www.google.com")
            ApplicationGraph.getToastManager().toast("Http get: $response")

        }).start()
        ApplicationGraph.getToastManager().toast("TODO\nOnBoarding uploaded")
    }
}
