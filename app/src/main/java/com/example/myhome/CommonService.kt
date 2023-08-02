package com.example.myhome

import android.content.SharedPreferences
import androidx.core.content.edit

class CommonService {
    fun indexConvertToName(index: Int): String {

        return if (index == 1) "밀"
        else if (index == 2) "딸기"
        else if (index == 3) "토마토"
        else if (index == 4) "솜"
        else if (index == 5) "당근"
        else if (index == 6) "감자"
        else if (index == 7) "옥수수"
        else if (index == 8) "사탕수수"
        else if (index == 9) "포도"
        else if (index == 10) "라벤더"
        else if (index == 11) "양배추"
        else if (index == 12) "바닐라"
        else if (index == 13) "콩"
        else if (index == 14) "사과"
        else if (index == 15) "오렌지"
        else if (index == 16) "복숭아"
        else if (index == 17) "고무"
        else if (index == 18) "커피"
        else if (index == 19) "카카오"
        else if (index == 20) "바나나"
        else if (index == 21) "야자열매"
        else if (index == 22) "체리"
        else if (index == 23) "레몬"
        else if (index == 24) "전나무 목재"
        else if (index == 25) "단풍나무 목재"
        else if (index == 26) "오동나무 목재"
        else if (index == 27) "호두나무 목재"
        else if (index == 28) "우유"
        else if (index == 29) "양털"
        else if (index == 30) "달걀"
        else if (index == 31) "토끼털"
        else if (index == 32) "거위털"
        else if (index == 33) "꿀"
        else if (index == 34) "누에고치"
        else if (index == 35) "꽁치"
        else if (index == 36) "새우"
        else if (index == 37) "랍스터"
        else if (index == 38) "연어"
        else if (index == 39) "참치"
        else if (index == 40) "상어"
        else if (index == 41) "고래"
        else if (index == 42) "광천수"
        else if (index == 43) "흙"
        else if (index == 44) "철"
        else if (index == 45) "소금"
        else if (index == 46) "석회석"
        else if (index == 47) "은"
        else if (index == 48) "금"
        else if (index == 49) "알루미늄 원석"
        else if (index == 50) "백금 원석"
        else if (index == 51) "빨간 별 열매"
        else if (index == 52) "노란 별 열매"
        else if (index == 53) "파란 별 열매"
        else if (index == 54) "초록 별 열매"
        else if (index == 55) "자수정"
        else if (index == 56) "에메랄드"
        else if (index == 57) "루비"
        else if (index == 58) "사파이어"
        else if (index == 59) "다이아몬드"
        else if (index == 60) "반짝반짝 주황 별모래"
        else if (index == 61) "반짝반짝 초록 별모래"
        else if (index == 62) "별빛 목재"
        else if (index == 63) "별빛 원석"
        else if (index == 64) "반짝반짝 파란 별가루"
        else if (index == 65) "반짝반짝 분홍 별가루"
        else if (index == 66) "별빛 약수"
        else if (index == 67) "별빛 이끼"
        else if (index == 68) "양가죽"
        else if (index == 69) "소고기"
        else if (index == 70) "아스파라거스"
        else if (index == 71) "소가죽"
        else if (index == 72) "말가죽"
        else if (index == 73) "닭고기"
        else if (index == 74) "양고기"
        else if (index == 75) "씨앗"
        else if (index == 76) "자갈"
        else if (index == 77) "묘목"
        else if (index == 78) "블루베리"
        else if (index == 79) "나무 넝쿨"
        else if (index == 80) "노란장미"
        else if (index == 81) "찻잎"
        else if (index == 82) "조개"
        else if (index == 83) "빨간 산호"
        else if (index == 84) "흰산호"
        else if (index == 85) "진주"
        else if (index == 86) "데코협회 감사 뱃지"
        else if (index == 87) "데코협회 뱃지"
        else if (index == 88) "로빈의 창고 열쇠"
        else if (index == 89) "로빈의 재고 장부"
        else if (index == 90) "로빈의 발자국 도장"
        else {
            ""
        }
    }

    fun defaultDataSetting(pref: SharedPreferences) {
        println(pref.getString("1", ""))
        pref.edit {
            putInt("1", 120)        //밀
            putInt("2", 300)        //딸기
            putInt("3", 490)        //토마토
            putInt("4", 4000)        //솜
            putInt("5", 1640)        //당근
            putInt("6", 3100)        //감자
            putInt("7", 3600)        //옥수수
            putInt("8", 5000)        //사탕수수
            putInt("9", 3600)        //포도
            putInt("10", 5500)        //라벤더
            putInt("11", 10000)        //양배추
            putInt("12", 9500)        //바닐라
            putInt("13", 2564)        //콩
            putInt("14", 500)        //사과
            putInt("15", 1206)        //오렌지
            putInt("16", 1000)        //복숭아
            putInt("17", 4000)        //고무
            putInt("18", 3000)        //커피
            putInt("19", 12000)        //카카오
            putInt("20", 994)        //바나나
            putInt("21", 1190)        //야자열매
            putInt("22", 1308)        //체리
            putInt("23", 1900)        //레몬
            putInt("24", 108)        //전나무 목재
            putInt("25", 6540)        //단풍나무 목재
            putInt("26", 4600)        //오동나무 목재
            putInt("27", 2612)        //호두나무 목재
            putInt("28", 420)        //우유
            putInt("29", 240)        //양털
            putInt("30", 400)        //달걀
            putInt("31", 794)        //토끼털
            putInt("32", 32000)        //거위털
            putInt("33", 1050)        //꿀
            putInt("34", 10820)        //누에고치
            putInt("35", 7760)        //꽁치
            putInt("36", 7840)        //새우
            putInt("37", 10000)        //랍스터
            putInt("38", 3100)        //연어
            putInt("39", 7000)        //참치
            putInt("40", 10000)        //상어
            putInt("41", 17600)        //고래
            putInt("42", 6000)        //광천수
            putInt("43", 6000)        //흙
            putInt("44", 7000)        //철
            putInt("45", 2400)        //소금
            putInt("46", 9000)        //석회석
            putInt("47", 12920)        //은
            putInt("48", 15600)        //금
            putInt("49", 19000)        //알루미늄 원석
            putInt("50", 14000)        //백금 원석
            putInt("51", 10000)        //빨간별
            putInt("52", 8000)        //노란별
            putInt("53", 30000)        //파란별
            putInt("54", 15000)        //초록별
            putInt("55", 70000)        //자수정
            putInt("56", 70000)        //에메랄드
            putInt("57", 70000)        //루비
            putInt("58", 70000)        //사파이어
            putInt("59", 70000)        //다이아몬드
            putInt("60", 86000)        //반짝반짝 주황 별모래
            putInt("61", 107000)        //반짝반짝 초록 별모래
            putInt("62", 26000)        //별빛 목재
            putInt("63", 28460)        //별빛 원석
            putInt("64", 198000)        //반짝반짝 파란 별가루
            putInt("65", 190000)        //반짝반짝 분홍 별가루
            putInt("66", 30000)        //별빛 약수
            putInt("67", 40000)        //별빛 이끼
            putInt("68", 4000)        //양가죽
            putInt("69", 552)        //소고기
            putInt("70", 1700)        //아스파라거스
            putInt("71", 1268)        //소가죽
            putInt("72", 3990)        //말가죽
            putInt("73", 6000)        //닭고기
            putInt("74", 5100)        //양고기
            putInt("75", 12)        //씨앗
            putInt("76", 8000)        //자갈
            putInt("77", 8000)        //묘목
            putInt("78", 700)        //블루베리
            putInt("79", 500)        //나무 넝쿨
            putInt("80", 4000)        //노란장미
            putInt("81", 2000)        //찻잎
            putInt("82", 5000)        //조개
            putInt("83", 4000)        //빨간 산호
            putInt("84", 7000)        //흰산호
            putInt("85", 1096)        //진주
        }

    }
}