package com.example.myhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null;
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileName = "your_file.txt"


    }
}