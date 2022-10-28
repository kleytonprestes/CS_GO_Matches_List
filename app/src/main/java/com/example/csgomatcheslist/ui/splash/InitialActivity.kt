package com.example.csgomatcheslist.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.csgomatcheslist.databinding.ActivityInitialScreenBinding
import com.example.csgomatcheslist.ui.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InitialActivity: AppCompatActivity()  {

    private var binding: ActivityInitialScreenBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInitialScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        GlobalScope.launch {
            delay(3000)
            startActivity(Intent(this@InitialActivity, MainActivity::class.java))
            finish()
        }
    }
}