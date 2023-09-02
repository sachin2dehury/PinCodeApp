package github.sachin2dehury.pincodeapp

class PinRepository(private val service: PinService) {

    suspend fun getPinData(pin: String) = service.getPinData(pin)
}