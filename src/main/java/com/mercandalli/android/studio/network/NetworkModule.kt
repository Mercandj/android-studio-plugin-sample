package com.mercandalli.android.studio.network

class NetworkModule {

    fun createNetworkManager(): NetworkManager {
        return NetworkManagerImpl()
    }
}
