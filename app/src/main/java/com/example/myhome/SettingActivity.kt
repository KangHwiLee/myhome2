package com.example.myhome

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.edit
import com.example.myhome.databinding.ActivitySettingBinding
import com.example.myhome.databinding.AutoTextViewBinding


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

        for(i:Int in 1..85){
            var mBinding2 : AutoTextViewBinding? = null
            mBinding2 = AutoTextViewBinding.inflate(layoutInflater)
            val binding2 = mBinding2
            var test : ConstraintLayout = binding2.itemField
            val imageBitmap = service.getImageFromAssets(this, "picture/default/"+i.toString()+".png")
            binding2.itemImage.setImageBitmap(imageBitmap)
            binding2.itemName1.text = service.indexConvertToName(i)
            binding2.editText1.setText(pref.getInt(i.toString(), 0).toString())
            binding2.editText1.keyListener = DigitsKeyListener.getInstance("0123456789")
            binding2.editText1.setOnFocusChangeListener {  view, hasFocus ->
                val id : Int = i;
                if(!hasFocus){
                var text = binding2.editText1.text.toString()
                    if(text == ""){
                        Toast.makeText(this@SettingActivity, "1이상 입력해야합니다", Toast.LENGTH_SHORT).show()
                        binding2.editText1.setText("1")
                        pref.edit {
                            putInt(id.toString(), 1)
                        }
                    }else{
                        pref.edit {
                            putInt(id.toString(), text.toInt())
                        }
                    }
                }
            }


            binding2.editText1.id = i
            binding.itemScroll.addView(test)


        }

        binding.root.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                // EditText가 아닌 영역을 터치하면 키보드를 숨김
                hideKeyboard()
            }
            false
        }
        binding.itemScroll.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                // EditText가 아닌 영역을 터치하면 키보드를 숨김
                hideKeyboard()
                binding.itemScroll.clearFocus()
            }
            false
        }
    }

    private fun hideKeyboard() {
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun isKeyboardVisible(editText : EditText): Boolean {
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        return inputManager.isActive(editText)
    }

}