package com.example.myhomecalculator

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException

class ItemLoad {

    fun readTextFromAssets(context: Context, fileName: String): String {
        val assetManager = context.assets
        return try {
            assetManager.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            "" // 파일을 읽지 못할 경우 빈 문자열 반환
        }

    }

}