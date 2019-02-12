package com.mercandalli.android.studio.network

import java.io.Closeable

internal object Closer {

    fun closeSilently(vararg xs: Closeable?) {
        for (x in xs) {
            try {
                x?.close()
            } catch (ignored: Throwable) {
            }
        }
    }
}
