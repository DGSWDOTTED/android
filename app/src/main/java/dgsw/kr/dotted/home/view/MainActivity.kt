package dgsw.kr.dotted.home.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
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

    lateinit var database : CompanyDatabase
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navBottom.background = null

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.navBottom.setupWithNavController(navHostFragment.findNavController())

        database = CompanyDatabase.getInstance(applicationContext)!!

        lifecycleScope.launch(Dispatchers.IO) {
            database.companyDao().deleteAll()
        }

        Log.d("도티드","MainActivity - onCreate() called")
        loadData()

    }

    private fun loadData() {
        val assetManager = this.assets
        val inputStream = assetManager.open("disabled.csv")
        val csvReader = CSVReader(InputStreamReader(inputStream,"EUC-KR"))

        val allContent = csvReader.readAll() as List<Array<String>>

        for (content in allContent) {
            val sb = StringBuilder("")

            //Log.d("데이터","${content[0]}")
            lifecycleScope.launch(Dispatchers.IO) {
                database.companyDao().insert(
                    CompanyEntity(
                        content[0],
                        content[1],
                        content[2],
                        content[3],
                        content[4],
                        content[5],
                        content[6],
                        content[7],
                        content[8],
                        content[9],
                        content[10]
                    )
                )
            }
        }
    }


}