package com.mercandalli.android.studio.version

import com.mercandalli.android.studio.main.ApplicationGraph

class VersionModule {

    fun createVersionManager(): VersionManager {
        val pluginManager = ApplicationGraph.getPluginManager()
        return VersionManagerImpl(
            pluginManager
        )
    }
}
