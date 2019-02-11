package com.mercandalli.android.studio.main

import com.mercandalli.android.studio.dialog.DialogModule
import com.mercandalli.android.studio.file_open.FileOpenModule
import com.mercandalli.android.studio.on_boarding.OnBoardingModule
import com.mercandalli.android.studio.plug_in.PluginModule
import com.mercandalli.android.studio.toast.ToastModule

class ApplicationGraph {

    private val fileOpenManager by lazy { FileOpenModule().createFileOpenManager() }
    private val errorManager by lazy { DialogModule().createErrorManager() }
    private val onBoardingManager by lazy { OnBoardingModule().createOnBoardingManager() }
    private val pluginManager by lazy { PluginModule(pluginId).createPluginManager() }
    private val toastManager by lazy { ToastModule().createToastManager() }

    companion object {

        private const val pluginId = "mercandalli.android-studio-plugin-sample"
        private val graph = ApplicationGraph()

        fun getFileOpenManager() = graph.fileOpenManager
        fun getErrorManager() = graph.errorManager
        fun getOnBoardingManager() = graph.onBoardingManager
        fun getPluginManager() = graph.pluginManager
        fun getToastManager() = graph.toastManager
    }
}
