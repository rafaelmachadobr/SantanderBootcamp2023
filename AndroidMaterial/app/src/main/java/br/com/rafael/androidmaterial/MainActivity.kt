package br.com.rafael.androidmaterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.rafael.androidmaterial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        insertListeners()
    }

    private fun insertListeners() {
        binding.cvButtons.setOnClickListener {
            startActivity(ButtonsActivity.getStartIntent(this))
        }
        binding.cvTextFields.setOnClickListener {
            startActivity(TextFieldsActivity.getStartIntent(this))
        }
    }
}