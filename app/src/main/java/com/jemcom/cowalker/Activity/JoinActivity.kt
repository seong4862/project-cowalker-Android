package com.jemcom.cowalker.Activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jemcom.cowalker.Network.ApplicationController
import com.jemcom.cowalker.Network.NetworkService
import com.jemcom.cowalker.Network.Post.PostJoin
import com.jemcom.cowalker.Network.Post.Response.PostJoinResponse
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when(v)
        {
            btn_join ->{
                post()
            }
        }
    }

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        networkService = ApplicationController.instance.networkSerVice
    }

    fun post()
    {
        var introduce = join_introduce_ed.text.toString()
        var portfolio = join_portfolio_url_ed.text.toString()
        var recruit_idx = "5b3e2ee66e351c1db0b33450"
        var answers : ArrayList<String> = ArrayList()
        var phone = join_phone_ed.text.toString()
        val pref = applicationContext.getSharedPreferences("auto", Activity.MODE_PRIVATE)
        val token = pref.getString("token","")

        answers.add(join_answer1_ed.text.toString())
        answers.add(join_answer2_ed.text.toString())

        var data = PostJoin(introduce,portfolio,recruit_idx,answers,phone)
        var postJoinResponse = networkService.postJoin(token,data)

        postJoinResponse.enqueue(object : Callback<PostJoinResponse>{
            override fun onFailure(call: Call<PostJoinResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"서버 연결 실패",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PostJoinResponse>?, response: Response<PostJoinResponse>?) {
                if(response!!.isSuccessful)
                {
                    var message = response.body()
                    Toast.makeText(applicationContext,"성공",Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(applicationContext,"실패",Toast.LENGTH_SHORT).show()
            }
        })
    }
}