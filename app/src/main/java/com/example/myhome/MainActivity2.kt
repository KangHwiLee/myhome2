package com.example.myhomecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomecalculator.databinding.ActivityMain2Binding
import com.example.myhomecalculator.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private var mBinding : ActivityMain2Binding? = null;
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileName = "your_file.txt"


    }
}