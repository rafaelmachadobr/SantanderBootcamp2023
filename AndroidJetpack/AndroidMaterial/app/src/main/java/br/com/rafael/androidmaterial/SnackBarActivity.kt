package br.com.rafael.androidmaterial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.androidmaterial.databinding.ActivitySnakeBarBinding
import com.google.android.material.snackbar.Snackbar

class SnackBarActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySnakeBarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showing.setOnClickListener {
            Snackbar.make(it, "Click no primeiro botão", Snackbar.LENGTH_LONG).show()
        }

        binding.action.setOnClickListener {
            Snackbar.make(it, "Click no segundo botão", Snackbar.LENGTH_LONG)
                .setAction("Go") {
                    Snackbar.make(it, "Click no botão de ação", Snackbar.LENGTH_LONG).show()
                }.show()
        }
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, SnackBarActivity::class.java)
    }
}
