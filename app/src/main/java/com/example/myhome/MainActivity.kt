package com.example.myhome

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.core.content.edit
import com.example.myhome.databinding.ActivityMainBinding
import com.example.myhomecalculator.ItemLoad

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null;
    private val binding get() = mBinding!!
    private var map = HashMap<Int, ArrayList<ArrayList<String>>>()
    private var ItemList = arrayListOf<Item> ()
    private var service : CommonService = CommonService()
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

             //마이홈 아이템 리스트 만들기
        var funItem:ItemLoad = ItemLoad();
        map  = funItem.readTextFromAssets(this, 0)
        pref = getSharedPreferences("option", MODE_PRIVATE)
        inquire()       //최초 접속인지 확인, sharedPreferences값 없으면 초기값 설정

        for(i:Int in 1 .. 9){
            var cnt:Int = 0
            map.get(i)?.forEach {
                var item:Item = Item(android.R.drawable.btn_star_big_on, it.get(0), cnt, i)
                ItemList.add(item);
                cnt ++
            }
        }

        val Adapter = UserAdapter(this, ItemList);
        binding.listView.adapter = Adapter                  //리스트 생성

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ ItemList, view, position, id ->
            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("info", map.get(Adapter.getType(position))?.get(Adapter.getCnt(position)))
            intent.putExtra("type", Adapter.getType(position))
            println(map.get(Adapter.getType(position))?.get(Adapter.getCnt(position)))
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            var intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }


    }
    fun listChange(test2 : String) : ArrayList<Item> {
        var list = arrayListOf<Item> ()
        for(i:Int in 11..20){
            var item:Item = Item(android.R.drawable.btn_star_big_on, "1", i, i)
            list.add(item);
        }
        return list
    }

    private fun inquire() {
        if(pref.getInt("1", 0) == 0){
            service.defaultDataSetting(pref);
        }
    }


}

