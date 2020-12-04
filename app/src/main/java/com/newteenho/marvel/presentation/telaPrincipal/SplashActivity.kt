package com.newteenho.marvel.presentation.telaPrincipal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.newteenho.marvel.R
import kotlinx.android.synthetic.main.activity_characters.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        delayStartActivity()
        hideStatusBarAndFullScreen()
    }

    private fun hideStatusBarAndFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    private fun delayStartActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, CharactersActivity::class.java))
            finish()
        }, 3000)
    }
}