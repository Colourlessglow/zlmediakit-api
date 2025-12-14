package zlmediakit.api.client

import zlmediakit.api.http.OkhttpAdapter
import zlmediakit.api.config.ZLMediaKitConfiguration

class ZLMediaKitClient(configuration: ZLMediaKitConfiguration) :
    ZLMediaKitClientAdapter(
        adapter = OkhttpAdapter(config = configuration),
        configuration = configuration
    ){
    constructor(secret: String, baseUrl: String) : this(
        configuration = ZLMediaKitConfiguration(
            secret = secret,
            baseUrl = baseUrl
        )
    )
}