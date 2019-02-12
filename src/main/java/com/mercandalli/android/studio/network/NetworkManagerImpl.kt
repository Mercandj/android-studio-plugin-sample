package com.mercandalli.android.studio.network

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class NetworkManagerImpl : NetworkManager {

    private val okHttpClient = lazy {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.build()
    }

    override fun get(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()
        var response: Response? = null
        var body: ResponseBody? = null
        try {
            response = okHttpClient.value.newCall(request).execute()
            body = response!!.body()
            return body!!.string()
        } catch (ignored: IOException) {
        } finally {
            Closer.closeSilently(body, response)
        }
        return null
    }
}
