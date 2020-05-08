package com.fmktechnologies.candostlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        var animresim = AnimationUtils.loadAnimation(this,R.anim.imageanim)
        imageViewpati.animation  = animresim

        var animtext = AnimationUtils.loadAnimation(this,R.anim.textanim)
        tvAnimals.animation = animtext



    }

    override fun onResume() {
        super.onResume()

        object : CountDownTimer(1800,1000) {
            override fun onFinish() {
                var intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()

    }
}
