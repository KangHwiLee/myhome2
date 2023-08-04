package com.example.myhome

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ImageView
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

        val editText = binding.itemSearch

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 선택된 항목의 인덱스(position)나 값을 가져와서 처리

                val Adapter = itemListInclude(position)
                binding.listView.adapter = Adapter
//                Adapter.notifyDataSetChanged()
                // 선택된 항목에 대한 동작을 여기에 구현
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("=====================2")
                // 아무 항목도 선택되지 않았을 때의 동작을 여기에 구현
            }
        }
        val textWatcher = object : TextWatcher {
            // EditText의 ID를 설정하는 메서드
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 입력하기 전 호출
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 입력 중 호출
                // 텍스트가 변경될 때마다 실행되는 코드를 여기에 작성
                val text = s.toString()
                // editTextId를 이용하여 EditText의 ID를 사용
            }
            override fun afterTextChanged(s: Editable?) {
                // 입력 후 호출
            }
        }

             //마이홈 아이템 리스트 만들기
        var funItem:ItemLoad = ItemLoad();
        map  = funItem.readTextFromAssets(this, 0)
        pref = getSharedPreferences("option", MODE_PRIVATE)
        inquire()       //최초 접속인지 확인, sharedPreferences값 없으면 초기값 설정

        val Adapter = itemListInclude(0)
        binding.listView.adapter = Adapter              //리스트 생성

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ ItemList, view, position, id ->
            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("info", map.get(Adapter.getType(position))?.get(Adapter.getCnt(position)))
            intent.putExtra("type", Adapter.getType(position))
            intent.putExtra("cnt", Adapter.getCnt(position))
            println(map.get(Adapter.getType(position))?.get(Adapter.getCnt(position)))
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            var intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }


    }
//    fun listChange(test2 : String) : ArrayList<Item> {
//        var list = arrayListOf<Item> ()
//        for(i:Int in 11..20){
//            var item:Item = Item(android.R.drawable.btn_star_big_on, "1", i, i)
//            list.add(item);
//        }
//        return list
//    }

    private fun inquire() {
        if(pref.getInt("1", 0) == 0){
            service.defaultDataSetting(pref);
        }
    }

    private fun itemListInclude(n:Int) : UserAdapter {
        ItemList.clear()
        if (n == 0) {
            ItemList.clear()
            for (i: Int in 1..8) {
                var cnt: Int = 0
                map.get(i)?.forEachIndexed { index, it ->
                    var item: Item = Item(
                        service.getImageFromAssets(
                            this,
                            "picture/"
                                    + service.SearchToFileName(i)
                                    + "/"
                                    + (index + 1).toString()
                                    + ".png"
                        ), it.get(0), cnt, i
                    )

                    ItemList.add(item);
                    cnt++
                }
            }
        } else {
            var cnt: Int = 0
            map.get(n)?.forEachIndexed { index, it ->
                var item: Item = Item(
                    service.getImageFromAssets(
                        this@MainActivity,
                        "picture/"
                                + service.SearchToFileName(n)
                                + "/"
                                + (index + 1).toString()
                                + ".png"
                    ), it.get(0), cnt, n
                )

                ItemList.add(item);
                cnt++
            }
        }
        return UserAdapter(this@MainActivity, ItemList);
    }


}
