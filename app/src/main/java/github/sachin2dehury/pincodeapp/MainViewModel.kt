package github.sachin2dehury.pincodeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PinRepository) : ViewModel() {

    private val _pinData = MutableStateFlow<PinResponse?>(null)
    val pinData = _pinData.asStateFlow()

    fun getPinData(pin: String) = viewModelScope.launch(Dispatchers.IO) {
        _pinData.value = repository.getPinData(pin).body()
    }
}