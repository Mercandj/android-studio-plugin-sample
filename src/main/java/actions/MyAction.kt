package actions

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class MyAction : AnAction() {

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val notificationGroup = NotificationGroup(
                "myplugin",
                NotificationDisplayType.BALLOON,
                true
        )
        notificationGroup.createNotification(
                "My Title",
                "My Message",
                NotificationType.INFORMATION,
                null
        ).notify(anActionEvent.project)
    }
}