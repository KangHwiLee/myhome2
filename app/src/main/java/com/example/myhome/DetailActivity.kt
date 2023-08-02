package com.example.myhome

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myhome.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private var mBinding : ActivityDetailBinding? = null;
    private val binding get() = mBinding!!

    private val service : CommonService = CommonService();

    private lateinit var tableLayout: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent.hasExtra("info")){
            println(intent.getStringArrayListExtra("info"))
        }


        tableLayout = binding.itemTable
        var text1 : String = "";
        intent.getStringArrayListExtra("info")?.forEachIndexed { index, s ->
            if(index > 0 && !s.trim().isEmpty()){
            addRowToTable(service.indexConvertToName(index), s, "test")
            }
            if(index > 88){
                return
            }
        }
        // 초기에 두 개의 행을 추가하는 예시
    }
    private fun addRowToTable(vararg cells: String) {
        val tableRow = TableRow(this)
        val layoutParams = TableRow.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        tableRow.layoutParams = layoutParams

        for (cellText in cells) {
            val textView = TextView(this)
            textView.text = cellText
            textView.gravity = Gravity.CENTER
            textView.setPadding(16, 16, 16, 16)
            tableRow.addView(textView)
        }

        tableLayout.addView(tableRow)
    }

}