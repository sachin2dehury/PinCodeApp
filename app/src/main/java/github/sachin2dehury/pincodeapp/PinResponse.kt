package github.sachin2dehury.pincodeapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PinResponse(
    val country: String? = null,
    @Json(name = "country abbreviation")
    val countryAbbreviation: String? = null,
    val places: List<Place?>? = null,
    @Json(name = "post code")
    val postCode: String? = null
) {
    @JsonClass(generateAdapter = true)
    data class Place(
        val latitude: String? = null,
        val longitude: String? = null,
        @Json(name = "place name")
        val placeName: String? = null,
        val state: String? = null,
        @Json(name = "state abbreviation")
        val stateAbbreviation: String? = null
    )
}