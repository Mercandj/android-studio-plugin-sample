package com.mercandalli.android.studio.on_boarding

import com.intellij.openapi.project.Project

interface OnBoardingManager {

    fun load(project: Project)

    fun save(project: Project)

    fun upload(project: Project)
}
