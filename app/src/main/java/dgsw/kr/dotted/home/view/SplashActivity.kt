package dgsw.kr.dotted.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import dgsw.kr.dotted.R


class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // 스플래시 화면이 표시될 시간(2초로 설정)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_screen)

        // 핸들러를 사용하여 일정 시간 이후에 메인 액티비티로 전환
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}