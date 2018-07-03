package com.jemcom.cowalker.Network.Post.Response

data class PostLoginResponse (
        var message : String,
        var token : String = null.toString()
)