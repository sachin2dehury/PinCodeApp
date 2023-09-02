package github.sachin2dehury.pincodeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import github.sachin2dehury.pincodeapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpUi()
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        lifecycleScope.launch {
            viewModel.pinData.collectLatest {
                val place = it?.places?.firstOrNull()
                val text = place?.placeName + "\n" + place?.state
                binding?.etOp?.text = text
                binding?.etOp?.isVisible = place != null
            }
        }
    }

    private fun setUpUi() = binding?.run {
        btn.setOnClickListener {
            val pin = etPin.text.toString()
            if (pin.length == 6) {
                viewModel.getPinData(pin)
            } else {
                Toast.makeText(this@MainActivity, "Enter 6 digit valid pincode", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}