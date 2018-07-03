package com.jemcom.cowalker

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.jemcom.cowalker.R.id.*
import kotlinx.android.synthetic.main.activity_create.*

class ProjectCreateActivity : AppCompatActivity(), View.OnClickListener {

    private var createNextBtn : Button? = null
    private var startUpBtn : Button? = null
    private var paricipateBtn : Button? = null
    private var studyBtn : Button? = null
    private var sideBtn : Button? = null
    private var blockChainBtn : Button? = null
    private var IoTBtn : Button? = null
    private var aiBtn : Button? = null
    private var design : Button? = null

    private var seoulBtn : Button? = null
    private var gyeonGi : Button? = null
    private var incheonBtn : Button? = null
    private var gangwonBtn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.parseColor("#FFFFFF")
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            window.statusBarColor = Color.BLACK
        }


        create_next_btn.setOnClickListener(this)
        create_startup_btn.setOnClickListener(this)
        create_competition_btn.setOnClickListener(this)
        create_study_btn.setOnClickListener(this)
        create_side_btn.setOnClickListener(this)
        create_create_btn.setOnClickListener(this)
        create_etc_btn.setOnClickListener(this)

        create_chain_btn.setOnClickListener(this)
        create_iot_btn.setOnClickListener(this)
        create_ai_btn.setOnClickListener(this)
        create_design_btn.setOnClickListener(this)
        create_contents_btn.setOnClickListener(this)
        create_subjectetc_btn.setOnClickListener(this)

        create_seoul_btn.setOnClickListener(this)
        create_gyeonggi_btn.setOnClickListener(this)
        create_incheon_btn.setOnClickListener(this)
        create_gangwon_btn.setOnClickListener(this)
        create_chungcheong_btn.setOnClickListener(this)
        create_jeolla_btn.setOnClickListener(this)
        create_gyeongsang_btn.setOnClickListener(this)
        create_jeju_btn.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        when(v){
            create_next_btn -> {
                // '방생성 버튼' 클릭 시 '초대 액티비티' 호출
               // val intent = Intent(applicationContext, ProjectCreate2Activity::class.java)
                val intent = Intent(applicationContext, ProjectCreate2Activity::class.java)
                startActivity(intent)
            }
           create_startup_btn -> {
                //create_startup_btn.setBackgroundColor((getResources().getColor(R.color.selectedBackground)))
               create_startup_btn.setSelected(true)
               create_startup_btn.setTextColor(Color.WHITE);

               create_competition_btn.setSelected(false)
               create_competition_btn.setTextColor(Color.BLACK)
               create_study_btn.setSelected(false)
               create_study_btn.setTextColor(Color.BLACK)
               create_side_btn.setSelected(false)
               create_side_btn.setTextColor(Color.BLACK)
               create_create_btn.setSelected(false)
               create_create_btn.setTextColor(Color.BLACK)
               create_etc_btn.setSelected(false)
               create_etc_btn.setTextColor(Color.BLACK)
            }
            create_competition_btn -> {
                //create_competition_btn.setBackgroundColor((getResources().getColor(R.color.selectedBackground)))
                create_competition_btn.setSelected(true)
                create_competition_btn.setTextColor(Color.WHITE);

                create_startup_btn.setSelected(false)
                create_startup_btn.setTextColor(Color.BLACK)
                create_study_btn.setSelected(false)
                create_study_btn.setTextColor(Color.BLACK)
                create_side_btn.setSelected(false)
                create_side_btn.setTextColor(Color.BLACK)
                create_create_btn.setSelected(false)
                create_create_btn.setTextColor(Color.BLACK)
                create_etc_btn.setSelected(false)
                create_etc_btn.setTextColor(Color.BLACK)
            }
            create_study_btn -> {
                //create_study_btn.setBackgroundColor((getResources().getColor(R.color.selectedBackground)))
                create_study_btn.setSelected(true)
                create_study_btn.setTextColor(Color.WHITE);

                create_startup_btn.setSelected(false)
                create_startup_btn.setTextColor(Color.BLACK)
                create_competition_btn.setSelected(false)
                create_competition_btn.setTextColor(Color.BLACK)
                create_side_btn.setSelected(false)
                create_side_btn.setTextColor(Color.BLACK)
                create_create_btn.setSelected(false)
                create_create_btn.setTextColor(Color.BLACK)
                create_etc_btn.setSelected(false)
                create_etc_btn.setTextColor(Color.BLACK)
            }
            create_side_btn -> {
                //create_side_btn.setBackgroundColor((getResources().getColor(R.color.selectedBackground)))
                create_side_btn.setSelected(true)
                create_side_btn.setTextColor(Color.WHITE);

                create_startup_btn.setSelected(false)
                create_startup_btn.setTextColor(Color.BLACK)
                create_competition_btn.setSelected(false)
                create_competition_btn.setTextColor(Color.BLACK)
                create_study_btn.setSelected(false)
                create_study_btn.setTextColor(Color.BLACK)
                create_create_btn.setSelected(false)
                create_create_btn.setTextColor(Color.BLACK)
                create_etc_btn.setSelected(false)
                create_etc_btn.setTextColor(Color.BLACK)
            }

            create_create_btn -> {
                create_create_btn.setSelected(true)
                create_create_btn.setTextColor(Color.WHITE)

                create_startup_btn.setSelected(false)
                create_startup_btn.setTextColor(Color.BLACK)
                create_competition_btn.setSelected(false)
                create_competition_btn.setTextColor(Color.BLACK)
                create_study_btn.setSelected(false)
                create_study_btn.setTextColor(Color.BLACK)
                create_side_btn.setSelected(false)
                create_side_btn.setTextColor(Color.BLACK)
                create_etc_btn.setSelected(false)
                create_etc_btn.setTextColor(Color.BLACK)
            }

            create_etc_btn -> {
                create_etc_btn.setSelected(true)
                create_etc_btn.setTextColor(Color.WHITE)

                create_startup_btn.setSelected(false)
                create_startup_btn.setTextColor(Color.BLACK)
                create_competition_btn.setSelected(false)
                create_competition_btn.setTextColor(Color.BLACK)
                create_study_btn.setSelected(false)
                create_study_btn.setTextColor(Color.BLACK)
                create_side_btn.setSelected(false)
                create_side_btn.setTextColor(Color.BLACK)
                create_create_btn.setSelected(false)
                create_create_btn.setTextColor(Color.BLACK)
            }

            // 분야 버튼
            create_chain_btn -> {
                create_chain_btn.setSelected(true)
                create_chain_btn.setTextColor(Color.WHITE);

                create_iot_btn.setSelected(false)
                create_iot_btn.setTextColor(Color.BLACK)
                create_ai_btn.setSelected(false)
                create_ai_btn.setTextColor(Color.BLACK)
                create_design_btn.setSelected(false)
                create_design_btn.setTextColor(Color.BLACK)
                create_contents_btn.setSelected(false)
                create_contents_btn.setTextColor(Color.BLACK)
                create_subjectetc_btn.setSelected(false)
                create_subjectetc_btn.setTextColor(Color.BLACK)

            }
            create_iot_btn -> {
                create_iot_btn.setSelected(true)
                create_iot_btn.setTextColor(Color.WHITE);

                create_chain_btn.setSelected(false)
                create_chain_btn.setTextColor(Color.BLACK)
                create_ai_btn.setSelected(false)
                create_ai_btn.setTextColor(Color.BLACK)
                create_design_btn.setSelected(false)
                create_design_btn.setTextColor(Color.BLACK)
                create_contents_btn.setSelected(false)
                create_contents_btn.setTextColor(Color.BLACK)
                create_subjectetc_btn.setSelected(false)
                create_subjectetc_btn.setTextColor(Color.BLACK)
            }
            create_ai_btn -> {
                create_ai_btn.setSelected(true)
                create_ai_btn.setTextColor(Color.WHITE);

                create_chain_btn.setSelected(false)
                create_chain_btn.setTextColor(Color.BLACK)
                create_iot_btn.setSelected(false)
                create_iot_btn.setTextColor(Color.BLACK)
                create_design_btn.setSelected(false)
                create_design_btn.setTextColor(Color.BLACK)
                create_contents_btn.setSelected(false)
                create_contents_btn.setTextColor(Color.BLACK)
                create_subjectetc_btn.setSelected(false)
                create_subjectetc_btn.setTextColor(Color.BLACK)
            }
            create_design_btn -> {
                create_design_btn.setSelected(true)
                create_design_btn.setTextColor(Color.WHITE);

                create_chain_btn.setSelected(false)
                create_chain_btn.setTextColor(Color.BLACK)
                create_iot_btn.setSelected(false)
                create_iot_btn.setTextColor(Color.BLACK)
                create_ai_btn.setSelected(false)
                create_ai_btn.setTextColor(Color.BLACK)
                create_contents_btn.setSelected(false)
                create_contents_btn.setTextColor(Color.BLACK)
                create_subjectetc_btn.setSelected(false)
                create_subjectetc_btn.setTextColor(Color.BLACK)
            }

            create_contents_btn -> {
                create_contents_btn.setSelected(true)
                create_contents_btn.setTextColor(Color.WHITE);

                create_chain_btn.setSelected(false)
                create_chain_btn.setTextColor(Color.BLACK)
                create_iot_btn.setSelected(false)
                create_iot_btn.setTextColor(Color.BLACK)
                create_ai_btn.setSelected(false)
                create_ai_btn.setTextColor(Color.BLACK)
                create_design_btn.setSelected(false)
                create_design_btn.setTextColor(Color.BLACK)
                create_subjectetc_btn.setSelected(false)
                create_subjectetc_btn.setTextColor(Color.BLACK)
            }

            create_subjectetc_btn -> {
                create_subjectetc_btn.setSelected(true)
                create_subjectetc_btn.setTextColor(Color.WHITE);

                create_chain_btn.setSelected(false)
                create_chain_btn.setTextColor(Color.BLACK)
                create_iot_btn.setSelected(false)
                create_iot_btn.setTextColor(Color.BLACK)
                create_ai_btn.setSelected(false)
                create_ai_btn.setTextColor(Color.BLACK)
                create_contents_btn.setSelected(false)
                create_contents_btn.setTextColor(Color.BLACK)
                create_design_btn.setSelected(false)
                create_design_btn.setTextColor(Color.BLACK)
            }

            // 지역

            create_seoul_btn -> {
                create_seoul_btn.setSelected(true)
                create_seoul_btn.setTextColor(Color.WHITE)

                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)

            }
            create_gyeonggi_btn -> {
                create_gyeonggi_btn.setSelected(true)
                create_gyeonggi_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_incheon_btn -> {
                create_incheon_btn.setSelected(true)
                create_incheon_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_gangwon_btn -> {
                create_gangwon_btn.setSelected(true)
                create_gangwon_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_chungcheong_btn -> {
                create_chungcheong_btn.setSelected(true)
                create_chungcheong_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_jeolla_btn -> {
                create_jeolla_btn.setSelected(true)
                create_jeolla_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_gyeongsang_btn -> {
                create_gyeongsang_btn.setSelected(true)
                create_gyeongsang_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_jeju_btn.setSelected(false)
                create_jeju_btn.setTextColor(Color.BLACK)
            }
            create_jeju_btn -> {
                create_jeju_btn.setSelected(true)
                create_jeju_btn.setTextColor(Color.WHITE)

                create_seoul_btn.setSelected(false)
                create_seoul_btn.setTextColor(Color.BLACK)
                create_gyeonggi_btn.setSelected(false)
                create_gyeonggi_btn.setTextColor(Color.BLACK)
                create_incheon_btn.setSelected(false)
                create_incheon_btn.setTextColor(Color.BLACK)
                create_gangwon_btn.setSelected(false)
                create_gangwon_btn.setTextColor(Color.BLACK)
                create_jeolla_btn.setSelected(false)
                create_jeolla_btn.setTextColor(Color.BLACK)
                create_chungcheong_btn.setSelected(false)
                create_chungcheong_btn.setTextColor(Color.BLACK)
                create_gyeongsang_btn.setSelected(false)
                create_gyeongsang_btn.setTextColor(Color.BLACK)
            }


        }
    }







//sdafsadfasdf
    override fun onBackPressed() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
    }
}
