package com.jemcom.cowalker.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jemcom.cowalker.Adapter.ChatAdapter
import com.jemcom.cowalker.Item.ChatItem
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity(),View.OnClickListener {

    var chatItems : ArrayList<ChatItem> = ArrayList()
    lateinit var chatAdapter : ChatAdapter

    override fun onClick(v: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        chatItems.add(ChatItem("이충엽","언제 시간이 가능하신가요?","56분 전"))
        chatItems.add(ChatItem("나","답장 주셔서 감사합니다.","2시간 전"))
        chatItems.add(ChatItem("이충엽","네~ 포트폴리오 잘 보았습니다! 그정도도 충분합니다.","56분 전"))
        chatItems.add(ChatItem("나","안녕하세요! 코워커 디자이너로 지원하게된 최다예입니다. 혹시 링크로 되어 있는 포트폴리오가 부족하다고" +
                "생각이 드시면 다른 포트폴리오도 보내드리겠습니다!","2시간 전"))


        chatAdapter = ChatAdapter(chatItems)
        chatAdapter.setOnItemClickListener(this)
        chat_rv.layoutManager = LinearLayoutManager(this)
        chat_rv.adapter = chatAdapter
    }
}
