package com.jemcom.cowalker.Activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jemcom.cowalker.Network.ApplicationController
import com.jemcom.cowalker.Network.Get.Response.GetApplyResponse
import com.jemcom.cowalker.Network.NetworkService
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_application.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplicationActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var networkService: NetworkService

    override fun onClick(v: View?) {
        when(v)
        {
            application_ok_btn -> {}
            application_reject_btn -> { }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        application_reject_btn.setOnClickListener(this)
        application_ok_btn.setOnClickListener(this)
        networkService = ApplicationController.instance.networkSerVice

        get()
    }

    fun get()
    {
        val pref = applicationContext.getSharedPreferences("auto", Activity.MODE_PRIVATE)
        val token = pref.getString("token","")
        var apply_idx = "5b3f1b2b8aec5b0d53065406"
        var getApplyMine = networkService.getApplyMine("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo0NSwiaWF0IjoxNTMwNjM3MDI0LCJleHAiOjE1MzMyMjkwMjR9.jSBD1bP-TN8-LM7de-tVmzQrwQlf-fVy7BzhUvfPNq8",apply_idx)

        getApplyMine.enqueue(object : Callback<GetApplyResponse>{

            override fun onFailure(call: Call<GetApplyResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"서버 연결 실패",Toast.LENGTH_SHORT).show()
                System.out.println("오류 : "+t.toString())
            }

            override fun onResponse(call: Call<GetApplyResponse>?, response: Response<GetApplyResponse>?) {
                if(response!!.isSuccessful)
                {
                    var message = response.body()

                    application_introduce_ed.setText(message.introduce)
                    application_portfolio_url_ed.setText(message.portfolio_url)
                    application_phone_ed.setText(message.phone)
                    application_answer1_ed.setText(message.answers[0])
                    application_answer2_ed.setText(message.answers[1])

                }
                else Toast.makeText(applicationContext,"실패",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
