package com.example.myhome

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myhome.databinding.ActivityMain2Binding
import java.util.regex.Pattern


class MainActivity2 : AppCompatActivity() {
    private var mBinding : ActivityMain2Binding? = null;
    private val binding get() = mBinding!!

    private lateinit var tableLayout: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent.hasExtra("info")){
            println(intent.getStringArrayListExtra("info"))
        }


        tableLayout = binding.itemTable
        var text1 : String = "";
        intent.getStringArrayListExtra("info")?.forEachIndexed { index, s ->
            if(index > 0 && !s.trim().isEmpty()){
            addRowToTable(indexConvertToName(index), s, "test")
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

    private fun indexConvertToName(index : Int) : String{
        return if(index == 1) "밀"
          else if(index == 2) "딸기"
          else if(index == 3) "토마토"
          else if(index == 4) "솜"
          else if(index == 5) "당근"
          else if(index == 6) "감자"
          else if(index == 7) "옥수수"
          else if(index == 8) "사탕수수"
          else if(index == 9) "포도"
          else if(index == 10) "라벤더"
          else if(index == 11) "양배추"
          else if(index == 12) "바닐라"
          else if(index == 13) "강낭콩"
          else if(index == 14) "사과"
          else if(index == 15) "오렌지"
          else if(index == 16) "복숭아"
          else if(index == 17) "고무"
          else if(index == 18) "커피"
          else if(index == 19) "카카오"
          else if(index == 20) "바나나"
          else if(index == 21) "야자열매"
          else if(index == 22) "체리"
          else if(index == 23) "레몬"
          else if(index == 24) "전나무 목재"
          else if(index == 25) "단풍나무 목재"
          else if(index == 26) "오동나무 목재"
          else if(index == 27) "호두나무 목재"
          else if(index == 28) "우유"
          else if(index == 29) "양털"
          else if(index == 30) "달걀"
          else if(index == 31) "토끼털"
          else if(index == 32) "거위털"
          else if(index == 33) "꿀"
          else if(index == 34) "누에고치"
          else if(index == 35) "꽁치"
          else if(index == 36) "새우"
          else if(index == 37) "랍스터"
          else if(index == 38) "연어"
          else if(index == 39) "참치"
          else if(index == 40) "상어"
          else if(index == 41) "고래"
          else if(index == 42) "광천수"
          else if(index == 43) "흙"
          else if(index == 44) "철"
          else if(index == 45) "소금"
          else if(index == 46) "석회석"
          else if(index == 47) "은"
          else if(index == 48) "금"
          else if(index == 49) "알루미늄 원석"
          else if(index == 50) "백금 원석"
          else if(index == 51) "빨간 별 열매"
          else if(index == 52) "노란 별 열매"
          else if(index == 53) "파란 별 열매"
          else if(index == 54) "초록 별 열매"
          else if(index == 55) "자수정"
          else if(index == 56) "에메랄드"
          else if(index == 57) "루비"
          else if(index == 58) "사파이어"
          else if(index == 59) "다이아몬드"
          else if(index == 60) "반짝반짝 주황 별모래"
          else if(index == 61) "반짝반짝 초록 별모래"
          else if(index == 62) "별빛 목재"
          else if(index == 63) "별빛 원석"
          else if(index == 64) "반짝반짝 파란 별가루"
          else if(index == 65) "반짝반짝 분홍 별가루"
          else if(index == 66) "별빛 약수"
          else if(index == 67) "별빛 이끼"
          else if(index == 68) "양가죽"
          else if(index == 69) "소고기"
          else if(index == 70) "아스파라거스"
          else if(index == 71) "소가죽"
          else if(index == 72) "말가죽"
          else if(index == 73) "닭고기"
          else if(index == 74) "양고기"
          else if(index == 75) "씨앗"
          else if(index == 76) "자갈"
          else if(index == 77) "묘목"
          else if(index == 78) "블루베리"
          else if(index == 79) "나무 넝쿨"
          else if(index == 80) "노란장미"
          else if(index == 81) "찻잎"
          else if(index == 82) "조개"
          else if(index == 83) "빨간 산호"
          else if(index == 84) "흰산호"
          else if(index == 85) "진주"
          else if(index == 86) "데코협회 감사 뱃지"
          else if(index == 87) "데코협회 뱃지"
          else if(index == 88) "로빈의 창고 열쇠"
          else if(index == 89) "로빈의 재고 장부"
          else if(index == 90) "로빈의 발자국 도장"
                else{""}
    }

}