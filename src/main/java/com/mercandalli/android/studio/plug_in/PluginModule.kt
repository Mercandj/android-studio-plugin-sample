package com.mercandalli.android.studio.plug_in

class PluginModule(
    private val pluginId: String
) {

    fun createPluginManager(): PluginManager {
        return PluginManagerImpl(
            pluginId
        )
    }
}
