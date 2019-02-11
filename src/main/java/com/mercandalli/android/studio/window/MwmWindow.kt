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
        title!!.text = "MWM On boarding"
        hideButton!!.addActionListener { toolWindow.hide(null) }
        loadButton!!.addActionListener {
            load()
        }
        saveButton!!.addActionListener {
            save()
        }
        testOnDeviceButton!!.addActionListener {
            testOnDevice()
        }
    }

    private fun load() {
        val fileOpenManager = ApplicationGraph.getFileOpenManager()
        fileOpenManager.open(
            "app/src/main/res/layout/activity_main.xml",
            project
        )
        ApplicationGraph.getToastManager().toast("OnBoarding loaded")
    }

    private fun save() {
        ApplicationGraph.getToastManager().toast("OnBoarding saved")
    }

    private fun testOnDevice() {
        //val actionManager = ActionManager.getInstance()
        //actionManager.getAction("Rerun").actionPerformed()
        //conte
        //AnActionEvent(
        //    null,
        //    dataContext,
        //    ActionPlaces.UNKNOWN,
        //    CheckboxAction.this.getTemplatePresentation(),
        //    actionManager,
        //    0)
        val commandProcessor = CommandProcessor.getInstance()
        commandProcessor.executeCommand(project, {
            ApplicationManager.getApplication().runWriteAction {
                RunAndroidAvdManagerAction().openAvdManager(project)
            }
        }, "Extract string resource", "Android Studio Plugin")

    }
}
