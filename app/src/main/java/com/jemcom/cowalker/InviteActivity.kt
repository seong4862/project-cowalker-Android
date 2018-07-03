package com.jemcom.cowalker

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InviteActivity : AppCompatActivity(), View.OnClickListener {

    private var createSecondBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)

        //
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

        createSecondBtn = findViewById<View>(R.id.create_second_btn) as Button

        createSecondBtn!!.setOnClickListener(this)

    }
    override fun onClick(v: View) {

        // '방생성 버튼' 클릭 시 '방생성 액티비티' 호출
        //val intent = Intent(applicationContext, InviteSecondActivity::class.java)
        val intent = Intent(applicationContext, testActivity::class.java)
        startActivity(intent)


    }
}
