package com.mercandalli.android.studio.on_boarding

import com.intellij.openapi.actionSystem.AnActionEvent

interface OnBoardingManager {

    fun load(anActionEvent: AnActionEvent)

    fun save(anActionEvent: AnActionEvent)
}
