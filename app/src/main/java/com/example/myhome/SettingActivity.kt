package com.example.myhome

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import com.example.myhome.databinding.ActivitySettingBinding
import com.example.myhome.databinding.AutoTextViewBinding
import org.w3c.dom.Text

class SettingActivity : AppCompatActivity() {
    private var mBinding : ActivitySettingBinding? = null
    private val binding get() = mBinding!!

    private lateinit var linearLayout: LinearLayout
    private val service : CommonService = CommonService()
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayout = binding.itemScroll
        pref = getSharedPreferences("option", MODE_PRIVATE)

        println(pref.getInt("1", 0))


        for(i:Int in 1..60){
            var mBinding2 : AutoTextViewBinding? = null
            mBinding2 = AutoTextViewBinding.inflate(layoutInflater)
            val binding2 = mBinding2
            var test : ConstraintLayout = binding2.itemField
            binding2.itemName1.text = service.indexConvertToName(i)
            binding2.editText1.setText(pref.getInt(i.toString(), 0).toString())

            binding2.editText1.keyListener = DigitsKeyListener.getInstance("0123456789")

            val textWatcher = object : TextWatcher {
                private var editTextId: Int = 0 // EditText의 ID를 저장할 변수

                // EditText의 ID를 설정하는 메서드
                fun setEditTextId(id: Int) {
                    editTextId = id
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // 입력하기 전 호출
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // 입력 중 호출
                    // 텍스트가 변경될 때마다 실행되는 코드를 여기에 작성
                    val text = s.toString()
                    pref.edit {
                        putInt(editTextId.toString(), text.toInt())
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                    // 입력 후 호출
                }
            }

            binding2.editText1.addTextChangedListener(textWatcher)

            binding2.editText1.id = i
            textWatcher.setEditTextId(binding2.editText1.id)
            binding.itemScroll.addView(test)


        }







//        val layoutParams = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            70 * resources.displayMetrics.density.toInt()
//        )
//
//        for(i:Int in 1 .. 85){
//        val constraintLayout = ConstraintLayout(this)
//        constraintLayout.layoutParams = layoutParams
//
//        // TextView 생성
//        val textView = TextView(this)
//        textView.id = View.generateViewId()
//        textView.text = service.indexConvertToName(i)
//        textView.setTextSize(2, 16.toFloat())
//        // EditText 생성
//        val editText = EditText(this)
//        editText.id = View.generateViewId()
//        editText.hint = "가격"
//        editText.setTextSize(2, 20.toFloat())
//        // TextView2 생성
//        val textView2 = TextView(this)
//        textView2.id = View.generateViewId()
//        textView2.text = "원"
//        textView2.setTextSize(2, 18.toFloat())
//        // 각 뷰들을 ConstraintLayout에 추가
//        constraintLayout.addView(textView)
//        constraintLayout.addView(editText)
//        constraintLayout.addView(textView2)
//
//        // ConstraintSet을 사용하여 뷰들에 제약 조건 설정
//        val constraintSet = ConstraintSet()
//        constraintSet.clone(constraintLayout)
//
//        // TextView의 제약 조건 설정
//        constraintSet.connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//        constraintSet.connect(textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//        constraintSet.connect(textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//        constraintSet.connect(textView.id, ConstraintSet.END, editText.id, ConstraintSet.START)
//
//        // EditText의 제약 조건 설정
//        constraintSet.connect(editText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//        constraintSet.connect(editText.id, ConstraintSet.END, textView2.id, ConstraintSet.START)
//        constraintSet.connect(editText.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//        constraintSet.connect(editText.id, ConstraintSet.START, textView.id, ConstraintSet.END)
//
//        // TextView2의 제약 조건 설정
//        constraintSet.connect(textView2.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//        constraintSet.connect(textView2.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//        constraintSet.connect(textView2.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//        constraintSet.connect(textView2.id, ConstraintSet.START, editText.id, ConstraintSet.END)
//
//        constraintSet.applyTo(constraintLayout)
//
//        // ConstraintLayout을 LinearLayout에 추가
//        linearLayout.addView(constraintLayout)
//
//        }

    }

}