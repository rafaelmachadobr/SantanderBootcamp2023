package br.com.rafael.androidmaterial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.androidmaterial.databinding.ActivityButtonsBinding

class ButtonsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityButtonsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, ButtonsActivity::class.java)
    }

}
