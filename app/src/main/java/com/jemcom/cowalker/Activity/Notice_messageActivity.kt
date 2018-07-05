package com.jemcom.cowalker.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_notice_message.*

class Notice_messageActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when(v)
        {
            notice_message_iv -> {
                notice_message_iv.isSelected = true
//                var intent = Intent(applicationContext,)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_message)
    }
}
