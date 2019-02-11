package com.mercandalli.android.studio.file_open

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project

interface FileOpenManager {

    fun open(projectRelativePath: String, anActionEvent: AnActionEvent)

    fun open(projectRelativePath: String, project: Project)
}
