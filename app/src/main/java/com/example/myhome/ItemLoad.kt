package com.example.myhomecalculator

import android.content.Context
import android.content.res.AssetManager
import com.example.myhome.CommonService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception

class ItemLoad {

    val service : CommonService = CommonService()

    fun readTextFromAssets(context: Context, CategoryFile: Int): HashMap<Int, ArrayList<ArrayList<String>>> {
        val originalMap = readToAllFile(context)
        val convertedMap = convertToArrayListOfStringLists(originalMap)
        return convertedMap
    }
    private fun readToAllFile(context : Context) : HashMap<Int, ArrayList<List<String>>>{
        val assetManager = context.assets
        var map = HashMap<Int, ArrayList<List<String>>>()

        var token : List<String>
        for(i : Int in 1 .. 8){
            var ItemList = arrayListOf<List<String>>()
            var fileName : String = service.SearchToFileName(i)
            val inputStream: InputStream = assetManager.open(fileName+".txt")
            try {
                inputStream.bufferedReader().readLines().forEach {
//                println(it)
                    token = it.split("\t")
                    CoroutineScope(Dispatchers.Main).launch {

//                        println(token.get(0).indexOf("가봉을 마친")) 검색
                    }
                    ItemList.add(token)
                }
            }catch (e : Exception){

            }
            map.put(i, ItemList)
        }
        return map
    }

    // ArrayList<List<String>>을 ArrayList<ArrayList<String>>으로 변환하는 함수를 추가합니다.
    private fun convertToArrayListOfStringLists(originalMap: HashMap<Int, ArrayList<List<String>>>)
            : HashMap<Int, ArrayList<ArrayList<String>>> {
        val convertedMap = HashMap<Int, ArrayList<ArrayList<String>>>()

        for ((key, value) in originalMap) {
            val convertedList = ArrayList<ArrayList<String>>()

            for (list in value) {
                val convertedInnerList = ArrayList<String>(list)
                convertedList.add(convertedInnerList)
            }

            convertedMap[key] = convertedList
        }

        return convertedMap
    }

//    private fun readToSearchCategory(type : Int) : String{
//
//        return ""
//    }

}