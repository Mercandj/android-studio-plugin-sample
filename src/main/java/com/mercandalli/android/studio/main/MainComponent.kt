package com.mercandalli.android.studio.main

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import com.intellij.util.xmlb.annotations.Attribute

@State(name = "MainComponent", storages = [Storage(value = "MainComponent.xml")])
class MainComponent :
    ApplicationComponent,
    PersistentStateComponent<MainComponent> {

    @Attribute
    private var localVersion: String = "00.00.00"
    private lateinit var version: String

    override fun getState(): MainComponent? = this

    override fun loadState(state: MainComponent) = XmlSerializerUtil.copyBean(state, this)

    override fun initComponent() {
        super.initComponent()
        val versionManager = ApplicationGraph.getVersionManager()
        version = versionManager.getVersion()
        if (isANewVersion()) {
            updateLocalVersion()
            val notificationGroup = NotificationGroup(
                "myplugin",
                NotificationDisplayType.BALLOON,
                true
            )
            notificationGroup.createNotification(
                "Plugin updated",
                "Welcome to the new version",
                NotificationType.INFORMATION,
                null
            ).notify(null)
        }
    }

    private fun isANewVersion(): Boolean {
        val s1 = localVersion.split("-")[0].split(".")
        val s2 = version.split("-")[0].split(".")

        if (s1.size != s2.size) return false
        var i = 0

        do {
            if (s1[i] < s2[i]) return true
            i++
        } while (i < s1.size && i < s2.size)

        return false
    }

    private fun updateLocalVersion() {
        localVersion = version
    }
}
