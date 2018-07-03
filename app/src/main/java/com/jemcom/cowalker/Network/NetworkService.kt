package com.jemcom.cowalker.Network

import com.jemcom.cowalker.Network.Post.PostLogin
import com.jemcom.cowalker.Network.Post.PostSignup
import com.jemcom.cowalker.Network.Post.Response.PostLoginResponse
import com.jemcom.cowalker.Network.Post.Response.PostSignupResponse
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/api/signup")
    fun postSignup(
            @Body signup: PostSignup
    ): Call<PostSignupResponse>

    @POST("/api/signup/check/{email}")
    fun postSignupCheck(
            @Path("email") email : String
    ) : Call<PostSignupResponse>

    @POST("/api/signin")
    fun postLogin(
            @Body login : PostLogin
    ) : Call<PostLoginResponse>
}