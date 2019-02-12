package com.mercandalli.android.studio.on_boarding

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil
import com.intellij.util.xmlb.annotations.Attribute
import java.io.Serializable

@State(name = "OnBoardingStorageComponent", storages = [Storage(value = "OnBoardingStorageComponent.xml")])
class OnBoardingStorageComponent :
    Serializable,
    PersistentStateComponent<OnBoardingStorageComponent> {

    @Attribute
    private var numberOfLoadPersisted = 0

    private val onBoardingStorage by lazy { createOnBoardingStorage() }

    override fun getState(): OnBoardingStorageComponent? = this

    override fun loadState(state: OnBoardingStorageComponent) = XmlSerializerUtil.copyBean(state, this)

    private fun createOnBoardingStorage() = object : OnBoardingStorage {

        override fun increaseNumberOfLoad() {
            numberOfLoadPersisted++
        }

        override fun getNumberOfLoadPersisted() = numberOfLoadPersisted
    }

    companion object {

        fun getInstance(project: Project): OnBoardingStorage =
            project.getComponent(OnBoardingStorageComponent::class.java)
                .onBoardingStorage
    }
}
