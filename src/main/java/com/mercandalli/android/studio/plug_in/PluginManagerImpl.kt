package com.mercandalli.android.studio.plug_in

import com.intellij.openapi.extensions.PluginId

class PluginManagerImpl(
    private val pluginId: String
) : PluginManager {

    private val id by lazy { PluginId.getId(pluginId) }
    private val plugin by lazy { com.intellij.ide.plugins.PluginManager.getPlugin(id)!! }
    private val versionInternal by lazy { plugin.version!! }

    override fun getVersion() = versionInternal

}
