package com.example.myhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import com.example.myhome.databinding.ActivityMainBinding
import com.example.myhomecalculator.ItemLoad

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null;
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ItemList = arrayListOf<Item> ()     //마이홈 아이템 리스트 만들기
        for(i:Int in 1..10){
            var item:Item = Item(android.R.drawable.btn_star_big_on, "1", i)
            ItemList.add(item);
        }
        val Adapter = UserAdapter(this, ItemList);
        binding.listView.adapter = Adapter                  //리스트 생성

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ ItemList, view, position, id ->
            println("==========================")
            println(Adapter.getAge(position))
            var ItemList = listChange("test")
            val Adapter = UserAdapter(this, ItemList);
            binding.listView.adapter = Adapter
        }
//        val fileName = "your_file.txt"
        var item:ItemLoad = ItemLoad();
        item.readTextFromAssets(this, "test")

    }

    fun listChange(test2 : String) : ArrayList<Item> {
        var ItemList = arrayListOf<Item> ()
        for(i:Int in 11..20){
            var item:Item = Item(android.R.drawable.btn_star_big_on, "1", i)
            ItemList.add(item);
        }
        return ItemList
    }



}