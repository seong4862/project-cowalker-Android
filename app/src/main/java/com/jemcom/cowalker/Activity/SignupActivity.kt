package com.jemcom.cowalker.Activity

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jemcom.cowalker.Network.NetworkService
import com.jemcom.cowalker.Network.Post.PostSignup
import com.jemcom.cowalker.Network.Post.Response.PostSignupResponse
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Response
class SignupActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var networkService: NetworkService
    lateinit var email : String
    lateinit var password : String
    lateinit var passwordck : String
    lateinit var name : String

    override fun onClick(v: View?) {
        when(v)
        {
            signup_ok_btn -> {
                signup_ok_btn.isSelected = true
                post()
                if(!password.equals(passwordck))
                {
                    signup_pwcheck_tv.setText("일치하지 않습니다.")
                    signup_pwcheck_tv.setTextColor(Color.parseColor("#ff6464"))
                    signup_email_ed.background.setColorFilter(Color.parseColor("#ff6464"),PorterDuff.Mode.SRC_IN)
                }
            }

            signup_emailcheck_tv -> {
                postCheck()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_email_tv.setVisibility(View.INVISIBLE)
        signup_pwcheck_tv.setVisibility(View.INVISIBLE)
        signup_name_tv.setVisibility(View.INVISIBLE)

        signup_emailcheck_tv.setOnClickListener(this)
        signup_ok_btn.setOnClickListener(this)


        email = signup_email_ed.text.toString()
        password = signup_pw_ed.text.toString()
        passwordck = signup_pwcheck_ed.text.toString()
        name = signup_name_ed.text.toString()

    }

    fun post()
    {
        var data = PostSignup(email, password, name)
        var postSignupResponse = networkService.postSignup(data)

        postSignupResponse.enqueue(object : retrofit2.Callback<PostSignupResponse>{

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                if(response.isSuccessful){
                    var intent = Intent(applicationContext,LoginActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable?) {
                Toast.makeText(applicationContext,"서버 연결 실패",Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun postCheck()
    {
        var postSignupckResponse = networkService.postSignupCheck(email)

        postSignupckResponse.enqueue(object : retrofit2.Callback<PostSignupResponse>{
            override fun onFailure(call: Call<PostSignupResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"서버 연결 실패",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PostSignupResponse>?, response: Response<PostSignupResponse>?) {
                if(response!!.isSuccessful)
                {
                    var message = response.body()
                    if(message.equals("Already Exists"))
                    {
                        signup_email_tv.setTextColor(Color.parseColor("#ff6464"))
                        signup_email_tv.setText("이미 등록된 이메일 입니다.")
                        signup_email_ed.background.setColorFilter(Color.parseColor("#ff6464"),PorterDuff.Mode.SRC_IN)
                    }
                    else if(message.equals("success"))
                    {
                        signup_email_tv.setText("사용 가능한 이메일 입니다.")
                    }
                }
            }
        })
    }
}
