package com.mercandalli.android.studio.window

import com.intellij.openapi.project.Project
import com.mercandalli.android.studio.on_boarding.OnBoardingManager
import com.mercandalli.android.studio.version.VersionManager

class MwmWindowPresenter(
    private val screen: MwmWindowContract.Screen,
    private val project: Project,
    private val onBoardingManager: OnBoardingManager,
    private val versionManager: VersionManager
) : MwmWindowContract.UserAction {

    override fun onCreate() {
        val version = versionManager.getVersion()
        val title = "Version: $version"
        screen.setTitle(title)
    }

    override fun onSaveClicked() {
        onBoardingManager.save(project)
    }

    override fun onLoadClicked() {
        onBoardingManager.load(project)
    }

    override fun onUploadClicked() {
        onBoardingManager.upload(project)
    }
}
