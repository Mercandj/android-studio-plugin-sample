package com.mercandalli.android.studio.version

import com.mercandalli.android.studio.plug_in.PluginManager

class VersionManagerImpl (
    private val pluginManager: PluginManager
): VersionManager {

    override fun getVersion(): String {
        return pluginManager.getPlugin().version
    }
}
