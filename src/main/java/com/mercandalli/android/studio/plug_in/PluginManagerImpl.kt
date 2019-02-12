package com.mercandalli.android.studio.plug_in

import com.intellij.openapi.extensions.PluginId

class PluginManagerImpl(
    private val pluginId: String
) : PluginManager {

    private val id by lazy { PluginId.getId(pluginId) }
    private val pluginInternal by lazy { com.intellij.ide.plugins.PluginManager.getPlugin(id)!! }

    override fun getPlugin() = pluginInternal
}
