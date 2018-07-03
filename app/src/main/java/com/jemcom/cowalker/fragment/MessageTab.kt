package com.jemcom.cowalker.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jemcom.cowalker.Adapter.MessageAdapter
import com.jemcom.cowalker.Item.MessageItem
import com.jemcom.cowalker.R
import kotlinx.android.synthetic.main.fragment_message.view.*

class MessageTab: Fragment(),View.OnClickListener {

    var messageItems : ArrayList<MessageItem> = ArrayList()
    lateinit var messageAdapter : MessageAdapter

    override fun onClick(v: View?) {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_message,container,false)

        messageItems.add(MessageItem(R.drawable.profile,"이충엽","언제 시간이 가능하신가요?","56분 전"))
        messageItems.add(MessageItem(R.drawable.profile,"손가은","개발은 얼마나 해보셨어요?","2시간 전"))


        messageAdapter = MessageAdapter(messageItems)
        messageAdapter.setOnItemClickListener(this)
        v.message_rv.layoutManager = LinearLayoutManager(v.context)
        v.message_rv.adapter = messageAdapter

        return v;
    }
}