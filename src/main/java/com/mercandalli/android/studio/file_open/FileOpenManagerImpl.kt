package com.mercandalli.android.studio.file_open

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.mercandalli.android.studio.toast.ToastManager

class FileOpenManagerImpl(
    private val toastManager: ToastManager
) : FileOpenManager {

    private val localFileSystem by lazy { LocalFileSystem.getInstance() }

    override fun open(
        projectRelativePath: String,
        anActionEvent: AnActionEvent
    ) = open(
        projectRelativePath,
        anActionEvent.project!!
    )

    override fun open(
        projectRelativePath: String,
        project: Project
    ) {
        val prefixedProjectRelativePath = if (projectRelativePath.startsWith("/")) {
            projectRelativePath
        } else {
            "/$projectRelativePath"
        }
        val projectBasePath = project.basePath
        val fileToOpenPath = "$projectBasePath$prefixedProjectRelativePath"
        val fileToOpen = localFileSystem.refreshAndFindFileByPath(fileToOpenPath)
            ?: return toastFileNotFound(fileToOpenPath)

        OpenFileDescriptor(
            project,
            fileToOpen
        ).navigate(true)
    }

    private fun toastFileNotFound(fileToOpenPath: String) {
        toastManager.toastError("File not found: $fileToOpenPath")
    }
}
