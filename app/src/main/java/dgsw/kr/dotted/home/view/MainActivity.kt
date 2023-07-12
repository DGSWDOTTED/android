package dgsw.kr.dotted.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dgsw.kr.dotted.R
import dgsw.kr.dotted.detail.view.DetailFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, DetailFragment())
            .commit()

    }
}