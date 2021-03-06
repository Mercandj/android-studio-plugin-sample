package com.mercandalli.android.studio.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.mercandalli.android.studio.main.ApplicationGraph

class AboutAction : AnAction() {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val versionManager = ApplicationGraph.getVersionManager()
        val version = versionManager.getVersion()
        ApplicationGraph.getToastManager().toast(
            "About:\nVersion $version"
        )
    }
}
