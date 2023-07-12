package dgsw.kr.dotted.home.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import com.opencsv.CSVReader
import dgsw.kr.dotted.R
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStreamReader


class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // 스플래시 화면이 표시될 시간(2초로 설정)


    lateinit var database : CompanyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_screen)

        // 핸들러를 사용하여 일정 시간 이후에 메인 액티비티로 전환
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)

        database = CompanyDatabase.getInstance(applicationContext)!!

        Log.d("도티드","MainActivity - onCreate() called")

        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
        val isLoaded = sharedPreference.getBoolean("isLoaded", false)

        if(!isLoaded) {

            loadData()
        }
    }

    private fun loadData() {
        val assetManager = this.assets
        val inputStream = assetManager.open("disabled.csv")
        val csvReader = CSVReader(InputStreamReader(inputStream,"EUC-KR"))

        val allContent = csvReader.readAll() as List<Array<String>>

        lifecycleScope.launch(Dispatchers.IO) {
            for (content in allContent) {
                val sb = StringBuilder("")
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

            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor  : SharedPreferences.Editor = sharedPreference.edit()
            editor.putBoolean("isLoaded",true)
            editor.commit()
        }
    }
}