package com.mercandalli.android.studio.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.mercandalli.android.studio.main.ApplicationGraph

class SaveOnBoardingAction : AnAction() {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val onBoardingManager = ApplicationGraph.getOnBoardingManager()
        onBoardingManager.save(anActionEvent)
    }
}
