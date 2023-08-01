package com.example.myhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.marginStart
import com.example.myhome.databinding.ActivitySettingBinding
import com.google.android.material.circularreveal.CircularRevealLinearLayout

class SettingActivity : AppCompatActivity() {
    private var mBinding : ActivitySettingBinding? = null
    private val binding get() = mBinding!!

    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayout = binding.itemScroll

        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            70 * resources.displayMetrics.density.toInt()
        )
        val constraintLayout = ConstraintLayout(this)
        constraintLayout.layoutParams = layoutParams

        // TextView 생성
        val textView = TextView(this)
        textView.id = View.generateViewId()
        textView.text = "TextView"

        // EditText 생성
        val editText = EditText(this)
        editText.id = View.generateViewId()
        editText.hint = "Name"

        // TextView2 생성
        val textView2 = TextView(this)
        textView2.id = View.generateViewId()
        textView2.text = "원"

        // 각 뷰들을 ConstraintLayout에 추가
        constraintLayout.addView(textView)
        constraintLayout.addView(editText)
        constraintLayout.addView(textView2)

        // ConstraintSet을 사용하여 뷰들에 제약 조건 설정
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        // TextView의 제약 조건 설정
        constraintSet.connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.connect(textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(textView.id, ConstraintSet.END, editText.id, ConstraintSet.START)

        // EditText의 제약 조건 설정
        constraintSet.connect(editText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.connect(editText.id, ConstraintSet.END, textView2.id, ConstraintSet.START)
        constraintSet.connect(editText.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(editText.id, ConstraintSet.START, textView.id, ConstraintSet.END)

        // TextView2의 제약 조건 설정
        constraintSet.connect(textView2.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.connect(textView2.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.connect(textView2.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(textView2.id, ConstraintSet.START, editText.id, ConstraintSet.END)

        constraintSet.applyTo(constraintLayout)

        // ConstraintLayout을 LinearLayout에 추가
        linearLayout.addView(constraintLayout)



    }

}