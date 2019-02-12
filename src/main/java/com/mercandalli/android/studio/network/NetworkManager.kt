package com.mercandalli.android.studio.network

interface NetworkManager {

    fun get(
        url: String
    ): String?
}
