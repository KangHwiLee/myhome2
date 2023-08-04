package com.example.myhome

import android.content.Context
import android.content.SharedPreferences
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import com.example.myhome.databinding.ActivityDetailBinding
import java.io.IOException
import java.io.InputStream


class DetailActivity : AppCompatActivity() {
    private var mBinding : ActivityDetailBinding? = null;
    private val binding get() = mBinding!!

    private val service : CommonService = CommonService();

    private lateinit var tableLayout: TableLayout

    lateinit var pref: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("option", MODE_PRIVATE)

        if(intent.hasExtra("info")){
            println(intent.getStringArrayListExtra("info"))
        }

        tableLayout = binding.itemTable
        var text1 : String = "";
        var price : Int = 0;

println(intent.getIntExtra("type", 0))
println(intent.getIntExtra("cnt", 0))

        binding.mainImage.setImageBitmap(service.getImageFromAssets(
            this,
            "picture/"
                    +service.SearchToFileName(intent.getIntExtra("type", 0))
                    +"/"
                    +(intent.getIntExtra("cnt", 0)+1).toString()
                    +".png"
        ))
        binding.

        run breaker@{
            intent.getStringArrayListExtra("info")?.forEachIndexed { index, s ->
                if(index == 0){
                    binding.itemExplan.text = s
                }
                else if (index > 0 && !s.trim().isEmpty()) {
                    addRowToTable(
                        index,
                        service.indexConvertToName(index),
                        s,
                        pref.getInt(index.toString(), 0).toString(),
                        (pref.getInt(index.toString(), 0) * s.toInt()).toString()
                    )
                    price += pref.getInt(index.toString(), 0) * s.toInt();
                }
                if (index > 88) {
                    return@breaker
                }
            }
        }
        binding.totalPrice.text = price.toString()+"원"
        // 초기에 두 개의 행을 추가하는 예시
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addRowToTable(i : Int, vararg cells: String) {
        val tableRow = TableRow(this)
        val layoutParams = TableRow.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        tableRow.layoutParams = layoutParams

        val imageView = ImageView(this)
        val imageBitmap = service.getImageFromAssets(this, "picture/default/"+i.toString()+".png")
        imageView.setImageBitmap(imageBitmap)
        tableRow.addView(imageView)
        for (cellText in cells) {
            val textView = TextView(this)
            textView.text = cellText
            textView.gravity = Gravity.CENTER
            textView.setPadding(16, 16, 16, 16)
            textView.setAutoSizeTextTypeUniformWithConfiguration(12, 14, 5, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
            tableRow.addView(textView)
        }

        tableLayout.addView(tableRow)
    }

//    private fun getImageFromAssets(context: Context, fileName: String): Bitmap? {
//        val assetManager: AssetManager = context.assets
//        return try {
//            val inputStream: InputStream = assetManager.open(fileName)
//            BitmapFactory.decodeStream(inputStream)
//        } catch (e: IOException) {
//            e.printStackTrace()
//            null
//        }
//    }

}