package com.mercandalli.android.studio.plug_in

import com.intellij.ide.plugins.IdeaPluginDescriptor

interface PluginManager {

    fun getPlugin(): IdeaPluginDescriptor
}
