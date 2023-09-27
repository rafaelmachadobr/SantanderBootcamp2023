package br.com.rafael.androidmaterial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.androidmaterial.databinding.ActivityBottomAppBarBinding
import br.com.rafael.androidmaterial.extensions.toast

class BottomAppBarActivity : AppCompatActivity() {

    private val binding by lazy { ActivityBottomAppBarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomAppBar.setNavigationOnClickListener {
            toast("Clicou no menu de navegação")
        }

        binding.fab.setOnClickListener {
            toast("Clicou no FAB")
        }

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    toast("Clicou no search")
                    true
                }

                R.id.more -> {
                    toast("Clicou no more")
                    true
                }

                else -> false
            }
        }
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, BottomAppBarActivity::class.java)
    }
}
