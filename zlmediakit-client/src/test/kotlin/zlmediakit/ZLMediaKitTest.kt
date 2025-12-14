package zlmediakit

import zlmediakit.api.client.ZLMediaKitClient
import kotlin.test.Test
import kotlin.test.assertTrue


class ZLMediaKitTest {

    @Test
    fun test() {
        val client = ZLMediaKitClient(
            secret = SECRET,
            baseUrl = BASE_URL
        )
        val apiList = client.getApiList()
        println(apiList)
        assertTrue(apiList.data.isNotEmpty())
    }

    companion object {
        const val BASE_URL: String = "http://127.0.0.1:8080"
        const val SECRET: String = "MSkc7O4hXbXqkLUAv5g9FQI14aTcGNwY"
    }
}