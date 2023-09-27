package br.com.rafael.androidmaterial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rafael.androidmaterial.databinding.ActivityTopAppBarBinding
import br.com.rafael.androidmaterial.extensions.toast

class TopAppBarActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTopAppBarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            toast("Clicou no menu de navegação")
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    toast("Clicou no botão de favoritos")
                    true
                }

                R.id.search -> {
                    toast("Clicou no botão de pesquisa")
                    true
                }

                R.id.more -> {
                    toast("Clicou no botão de mais")
                    true
                }

                else -> false
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, TopAppBarActivity::class.java)
    }
}
