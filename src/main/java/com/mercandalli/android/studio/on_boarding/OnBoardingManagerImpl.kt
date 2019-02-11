package com.mercandalli.android.studio.on_boarding

import com.intellij.openapi.actionSystem.AnActionEvent
import com.mercandalli.android.studio.file_open.FileOpenManager
import com.mercandalli.android.studio.main.ApplicationGraph

class OnBoardingManagerImpl(
    private val fileOpenManager: FileOpenManager
) : OnBoardingManager {

    override fun load(anActionEvent: AnActionEvent) {
        fileOpenManager.open(
            "app/src/main/res/layout/activity_main.xml",
            anActionEvent
        )
        ApplicationGraph.getToastManager().toast("OnBoarding loaded")
    }

    override fun save(anActionEvent: AnActionEvent) {
        ApplicationGraph.getToastManager().toast("TODO\nOnBoarding saved")
    }
}
