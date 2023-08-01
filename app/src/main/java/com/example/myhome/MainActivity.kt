package com.example.myhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.myhome.databinding.ActivityMainBinding
import com.example.myhomecalculator.ItemLoad

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null;
    private val binding get() = mBinding!!
    private var map = HashMap<Int, ArrayList<ArrayList<String>>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ItemList = arrayListOf<Item> ()     //마이홈 아이템 리스트 만들기
        var funItem:ItemLoad = ItemLoad();
        map  = funItem.readTextFromAssets(this, 0)



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
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("info", map.get(Adapter.getType(position))?.get(Adapter.getCnt(position)))
            intent.putExtra("type", Adapter.getType(position))
            startActivity(intent)
        }


    }



    fun listChange(test2 : String) : ArrayList<Item> {
        var ItemList = arrayListOf<Item> ()
        for(i:Int in 11..20){
            var item:Item = Item(android.R.drawable.btn_star_big_on, "1", i, i)
            ItemList.add(item);
        }
        return ItemList
    }



}