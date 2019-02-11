package com.mercandalli.android.studio.window

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class MwmWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val mwmWindow = MwmWindow(
            toolWindow,
            project
        )
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(
            mwmWindow.winContent,
            "",
            false
        )
        toolWindow.contentManager.addContent(content)
    }
}
