package com.jemcom.cowalker.Network

import com.jemcom.cowalker.Network.Get.Response.GetApplyResponse
import com.jemcom.cowalker.Network.Get.Response.GetMessageLookResponse
import com.jemcom.cowalker.Network.Get.Response.GetMessageResponse
import com.jemcom.cowalker.Network.Get.Response.GetSignupResponse
import com.jemcom.cowalker.Network.Post.PostJoin
import com.jemcom.cowalker.Network.Post.PostLogin
import com.jemcom.cowalker.Network.Post.PostMessageSend
import com.jemcom.cowalker.Network.Post.PostSignup
import com.jemcom.cowalker.Network.Post.Response.PostJoinResponse
import com.jemcom.cowalker.Network.Post.Response.PostLoginResponse
import com.jemcom.cowalker.Network.Post.Response.PostMessageResponse
import com.jemcom.cowalker.Network.Post.Response.PostSignupResponse
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/api/signup")
    fun postSignup(
            @Body signup: PostSignup
    ): Call<PostSignupResponse>

    @GET("/api/signup/check")
    fun getSignupCheck(
            @Query("email") email : String
    ) : Call<GetSignupResponse>

    @POST("/api/signin")
    fun postLogin(
            @Body login : PostLogin
    ) : Call<PostLoginResponse>

    @POST("/api/apply")
    fun postJoin(
            @Header("authorization") authorization : String,
            @Body join : PostJoin
    ) : Call<PostJoinResponse>

    @GET("/api/apply/{apply_idx}")
    fun getApplyMine(
            @Header("authorization") authorization : String,
            @Path("apply_idx") apply_idx : String
    ) : Call<GetApplyResponse>

    @POST("/api/message/{user_id}")
    fun postMessage(
            @Header("authorization") authorization : String,
            @Body contents : PostMessageSend,
            @Path("user_id") user_id : String
    ) : Call<PostMessageResponse>

    @GET("/api/message")
    fun getMessage(
            @Header("authorization") authorization: String
    ) : Call<GetMessageResponse>
    @GET("/api/message/{partner_id}")
    fun getMessageLook(
            @Header("authorization") authorization: String,
            @Path("partner_id") partner_id : String
    ) : Call<GetMessageLookResponse>
}