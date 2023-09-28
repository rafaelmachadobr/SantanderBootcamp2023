package br.com.rafael.androidmaterial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.rafael.androidmaterial.databinding.ActivityBottomNavigationBinding
import br.com.rafael.androidmaterial.extensions.toast
import br.com.rafael.androidmaterial.fragments.FavoriteFragment
import br.com.rafael.androidmaterial.fragments.HomeFragment

class BottomNavigationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityBottomNavigationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> openFragment(HomeFragment.newInstance())
                R.id.favorite -> openFragment(FavoriteFragment.newInstance())
            }
            true
        }

        binding.bottomNavigation.selectedItemId = R.id.home
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, BottomNavigationActivity::class.java)
    }
}
