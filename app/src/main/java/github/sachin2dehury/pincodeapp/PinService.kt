package github.sachin2dehury.pincodeapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PinService {

    @GET("https://api.zippopotam.us/in/{pin}")
    suspend fun getPinData(
        @Path("pin") pin: String = "769014"
    ): Response<PinResponse>

    companion object {
        const val BASE_URL = "https://api.zippopotam.us/in/"
    }
}