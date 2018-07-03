package com.jemcom.cowalker.Activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jemcom.cowalker.MainActivity
import com.jemcom.cowalker.Network.ApplicationController
import com.jemcom.cowalker.Network.NetworkService
import com.jemcom.cowalker.Network.Post.PostLogin
import com.jemcom.cowalker.Network.Post.Response.PostLoginResponse
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var networkService: NetworkService
    lateinit var email : String
    lateinit var password : String

    override fun onClick(v: View?) {
        when(v)
        {
            login_signup_btn -> {
                val intent= Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
            }

            login_ok_btn -> {
                login_ok_btn.isSelected = true
                post()
            }

            login_auto_txt -> {
                if(login_auto_txt.textColors.defaultColor != Color.parseColor("#444444")) {
                    login_check_btn.setVisibility(View.VISIBLE)
                    login_auto_txt.setTextColor(Color.parseColor("#444444"))
                }
                else
                {
                    login_check_btn.setVisibility(View.INVISIBLE)
                    login_auto_txt.setTextColor(Color.parseColor("#c5c5c5"))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_check_btn.setVisibility(View.INVISIBLE)
        login_auto_txt.setOnClickListener(this)
        login_ok_btn.setOnClickListener(this)
        login_signup_btn.setOnClickListener(this)

        networkService = ApplicationController.instance.networkSerVice
    }

    fun post()
    {
        email = login_email_ed.text.toString()
        password = login_pw_ed.text.toString()
        System.out.println(email + "하고" + password)

        var data = PostLogin(email,password)
        var postLoginResponse = networkService.postLogin(data)

        postLoginResponse.enqueue(object : Callback<PostLoginResponse>{
            override fun onFailure(call: Call<PostLoginResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"서버 연결 실패", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PostLoginResponse>?, response: Response<PostLoginResponse>?) {
                var message = response!!.body()
                if(response!!.isSuccessful)
                {
                    if(message.message.equals("login success"))
                    {
                        var intent = Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else if(message.message.equals("wrong password"))
                    {
                        Toast.makeText(applicationContext,"비밀번호가 틀렸습니다",Toast.LENGTH_SHORT).show()
                    }
                    else if(message.message.equals("wrong email"))
                    {
                        Toast.makeText(applicationContext,"이메일이 틀렸습니다",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
