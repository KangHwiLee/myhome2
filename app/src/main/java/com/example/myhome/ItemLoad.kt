package com.example.myhomecalculator

import android.content.Context
import android.content.res.AssetManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception

class ItemLoad {

    fun readTextFromAssets(context: Context, fileName: String): String {

        val termsString = StringBuilder()
        val reader: BufferedReader

        val assetManager = context.assets
        val inputStream: InputStream = assetManager.open("gajuk.txt")
        try {
            inputStream.bufferedReader().readLines().forEach {
//                println(it)
                var token = it.split("\t")
                CoroutineScope(Dispatchers.Main).launch {
                   println(token.get(0).indexOf("가봉을 마친"))
                }
            }
        }catch (e : Exception){

        }

        return ""
    }

}