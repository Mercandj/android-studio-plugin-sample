package com.mercandalli.android.studio.window

import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.mercandalli.android.studio.main.ApplicationGraph

import javax.swing.*
import com.intellij.openapi.application.ApplicationManager
import org.jetbrains.android.actions.RunAndroidAvdManagerAction

// https://github.com/JetBrains/intellij-sdk-docs/tree/master/code_samples/tool_window
class MwmWindow(
    private val toolWindow: ToolWindow,
    private val project: Project
) {

    private val userAction = createUserAction()
    private var loadButton: JButton? = null
    private var saveButton: JButton? = null
    private var testOnDeviceButton: JButton? = null
    private var hideButton: JButton? = null
    private var uploadButton: JButton? = null
    private var image: JLabel? = null
    private var title: JLabel? = null
    var winContent: JPanel? = null

    init {
        image!!.icon = ImageIcon(javaClass.getResource("/window/mwm.png"))
        image!!.text = ""
        hideButton!!.addActionListener {
            toolWindow.hide(null)
        }
        loadButton!!.addActionListener {
            userAction.onLoadClicked()
        }
        saveButton!!.addActionListener {
            userAction.onSaveClicked()
        }
        uploadButton!!.addActionListener {
            userAction.onUploadClicked()
        }
        testOnDeviceButton!!.addActionListener {
            testOnDevice()
        }
        userAction.onCreate()
    }

    private fun testOnDevice() {
        val commandProcessor = CommandProcessor.getInstance()
        commandProcessor.executeCommand(project, {
            ApplicationManager.getApplication().runWriteAction {
                RunAndroidAvdManagerAction().openAvdManager(project)
            }
        }, "Extract string resource", "Android Studio Plugin")
    }

    private fun createScreen() = object : MwmWindowContract.Screen {

        override fun setTitle(text: String) {
            title!!.text = text
        }
    }

    private fun createUserAction(): MwmWindowContract.UserAction {
        val screen = createScreen()
        val onBoardingManager = ApplicationGraph.getOnBoardingManager()
        val versionManager = ApplicationGraph.getVersionManager()
        return MwmWindowPresenter(
            screen,
            project,
            onBoardingManager,
            versionManager
        )
    }
}
