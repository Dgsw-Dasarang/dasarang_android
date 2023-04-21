package co.dasa.data.network.interceptor

import co.dasa.data.network.url.DasaUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {
    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val newRequest = this.request().newBuilder()
            .addHeader(
                "key",
                DasaUrl.API_KEY
            )
            .build()
        proceed(newRequest)
    }
}