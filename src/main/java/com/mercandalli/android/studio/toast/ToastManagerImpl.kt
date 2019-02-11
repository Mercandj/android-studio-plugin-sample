package com.mercandalli.android.studio.toast

import com.intellij.CommonBundle
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications

class ToastManagerImpl : ToastManager {

    override fun toast(message: String) {
        Notifications.Bus.notify(
            Notification(
                Notifications.SYSTEM_MESSAGES_GROUP_ID,
                "MWM",
                message,
                NotificationType.INFORMATION
            )
        )
    }

    override fun toastError(message: String) {
        Notifications.Bus.notify(
            Notification(
                Notifications.SYSTEM_MESSAGES_GROUP_ID,
                CommonBundle.getErrorTitle(),
                message,
                NotificationType.ERROR
            )
        )
    }
}
