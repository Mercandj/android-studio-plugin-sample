package com.mercandalli.android.studio.main

import com.mercandalli.android.studio.dialog.DialogModule
import com.mercandalli.android.studio.file_open.FileOpenModule
import com.mercandalli.android.studio.network.NetworkModule
import com.mercandalli.android.studio.on_boarding.OnBoardingModule
import com.mercandalli.android.studio.plug_in.PluginModule
import com.mercandalli.android.studio.toast.ToastModule
import com.mercandalli.android.studio.version.VersionModule

class ApplicationGraph {

    private val fileOpenManager by lazy { FileOpenModule().createFileOpenManager() }
    private val errorManager by lazy { DialogModule().createErrorManager() }
    private val networkManager by lazy { NetworkModule().createNetworkManager() }
    private val onBoardingManager by lazy { OnBoardingModule().createOnBoardingManager() }
    private val pluginManager by lazy { PluginModule(pluginId).createPluginManager() }
    private val toastManager by lazy { ToastModule().createToastManager() }
    private val versionManager by lazy { VersionModule().createVersionManager() }

    companion object {

        private const val pluginId = "mercandalli.android-studio-plugin-sample"
        private var graph: ApplicationGraph? = null

        private fun initialize() {
            if (graph != null) {
                return
            }
            graph = ApplicationGraph()
        }

        private fun getGraph(): ApplicationGraph {
            if (graph == null) {
                initialize()
            }
            return graph!!
        }

        fun getFileOpenManager() = getGraph().fileOpenManager
        fun getErrorManager() = getGraph().errorManager
        fun getNetworkManager() = getGraph().networkManager
        fun getOnBoardingManager() = getGraph().onBoardingManager
        fun getPluginManager() = getGraph().pluginManager
        fun getToastManager() = getGraph().toastManager
        fun getVersionManager() = getGraph().versionManager

    }
}
