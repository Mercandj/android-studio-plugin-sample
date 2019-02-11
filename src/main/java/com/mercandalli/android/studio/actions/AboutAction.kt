package com.mercandalli.android.studio.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.mercandalli.android.studio.main.ApplicationGraph

class AboutAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val pluginManager = ApplicationGraph.getPluginManager()
        val version = pluginManager.getVersion()
        ApplicationGraph.getToastManager().toast(
                "About:\nVersion $version"
        )
    }
}
