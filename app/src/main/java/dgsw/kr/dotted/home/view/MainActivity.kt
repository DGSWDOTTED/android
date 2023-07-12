package dgsw.kr.dotted.home.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.opencsv.CSVReader
import dgsw.kr.dotted.R
import dgsw.kr.dotted.databinding.ActivityMainBinding
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.navBottom.background = null

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.navBottom.setupWithNavController(navHostFragment.findNavController())

    }

    fun handleBottomNavigation(state : Boolean){
        if (state)binding.navBottom.visibility = View.VISIBLE
        else binding.navBottom.visibility = View.INVISIBLE
    }




}