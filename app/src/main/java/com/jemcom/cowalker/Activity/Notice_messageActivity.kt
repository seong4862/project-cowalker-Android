package com.jemcom.cowalker.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_notice_message.*

class Notice_messageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_message)
        val intent = getIntent()
        if(intent != null) {
            notice_message_ed.setText(intent.getStringExtra("position"))
            Log.d("position",intent.getStringExtra("position").toString())
        }
        else notice_message_ed.setText("엥??")
    }
}
