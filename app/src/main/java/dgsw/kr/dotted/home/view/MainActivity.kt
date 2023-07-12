package dgsw.kr.dotted.home.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.opencsv.CSVReader
import dgsw.kr.dotted.R
import dgsw.kr.dotted.local.DB.CompanyDao
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    lateinit var database : CompanyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            Log.d("데이터","${content[0]}")
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