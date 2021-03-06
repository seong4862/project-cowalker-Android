package com.jemcom.cowalker

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_invite.*

class InviteActivity : AppCompatActivity(), View.OnClickListener {

    private var createSecondBtn: Button? = null
    internal lateinit var startZeroMonth: String
    internal lateinit var startZeroDay: String
    internal lateinit var finishZeroMonth: String
    internal lateinit var finishZeroDay: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)

        // 모집 역할 버튼 리스너
        invite_pm_btn.setOnClickListener(this)
        invite_planner_btn.setOnClickListener(this)
        invite_designer_btn.setOnClickListener(this)
        invite_developer_btn.setOnClickListener(this)
        invite_etc_btn.setOnClickListener(this)

        // 다음 버튼 리스너
        invite_next_btn.setOnClickListener(this)
        // 날짜 선택 버튼 리스너
        invite_range_tv.setOnClickListener(this)
        //
        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.parseColor("#FFFFFF")
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            window.statusBarColor = Color.BLACK
        }



    }
    override fun onClick(v: View) {

            when(v){
                invite_pm_btn -> {
                    invite_pm_btn.setSelected(true)
                    invite_pm_btn.setTextColor(Color.WHITE)

                    invite_planner_btn.setSelected(false)
                    invite_planner_btn.setTextColor(Color.BLACK)
                    invite_designer_btn.setSelected(false)
                    invite_designer_btn.setTextColor(Color.BLACK)
                    invite_developer_btn.setSelected(false)
                    invite_developer_btn.setTextColor(Color.BLACK)
                    invite_etc_btn.setSelected(false)
                    invite_etc_btn.setTextColor(Color.BLACK)
                }

                invite_planner_btn -> {
                    invite_planner_btn.setSelected(true)
                    invite_planner_btn.setTextColor(Color.WHITE)

                    invite_pm_btn.setSelected(false)
                    invite_pm_btn.setTextColor(Color.BLACK)
                    invite_designer_btn.setSelected(false)
                    invite_designer_btn.setTextColor(Color.BLACK)
                    invite_developer_btn.setSelected(false)
                    invite_developer_btn.setTextColor(Color.BLACK)
                    invite_etc_btn.setSelected(false)
                    invite_etc_btn.setTextColor(Color.BLACK)
                }

                invite_designer_btn -> {
                    invite_designer_btn.setSelected(true)
                    invite_designer_btn.setTextColor(Color.WHITE)

                    invite_pm_btn.setSelected(false)
                    invite_pm_btn.setTextColor(Color.BLACK)
                    invite_planner_btn.setSelected(false)
                    invite_planner_btn.setTextColor(Color.BLACK)
                    invite_developer_btn.setSelected(false)
                    invite_developer_btn.setTextColor(Color.BLACK)
                    invite_etc_btn.setSelected(false)
                    invite_etc_btn.setTextColor(Color.BLACK)
                }

                invite_developer_btn -> {
                    invite_developer_btn.setSelected(true)
                    invite_developer_btn.setTextColor(Color.WHITE)

                    invite_pm_btn.setSelected(false)
                    invite_pm_btn.setTextColor(Color.BLACK)
                    invite_planner_btn.setSelected(false)
                    invite_planner_btn.setTextColor(Color.BLACK)
                    invite_designer_btn.setSelected(false)
                    invite_designer_btn.setTextColor(Color.BLACK)
                    invite_etc_btn.setSelected(false)
                    invite_etc_btn.setTextColor(Color.BLACK)
                }

                invite_etc_btn -> {
                    invite_etc_btn.setSelected(true)
                    invite_etc_btn.setTextColor(Color.WHITE)

                    invite_pm_btn.setSelected(false)
                    invite_pm_btn.setTextColor(Color.BLACK)
                    invite_planner_btn.setSelected(false)
                    invite_planner_btn.setTextColor(Color.BLACK)
                    invite_designer_btn.setSelected(false)
                    invite_designer_btn.setTextColor(Color.BLACK)
                    invite_developer_btn.setSelected(false)
                    invite_developer_btn.setTextColor(Color.BLACK)
                }

                invite_next_btn -> {
                    val intent = Intent(applicationContext, Invite2Activity::class.java)
                    startActivity(intent)
                }

                invite_range_tv -> {
                    val pd = MyYearMonthPickerDialog()
                    pd.setOnConfirmDateListener(object : MyYearMonthPickerDialog.OnConfirmDateListener {
                        override fun onConfirmDateListener(startYear: Int, startMonth: Int, startDay: Int, finishYear: Int, finishMonth: Int, finishDay: Int) {
                            var startDay = startDay
                            var finishDay = finishDay
                            if (startMonth < 10) {
                                startZeroMonth = "0"+startMonth
                            } else {
                                startZeroMonth = Integer.toString(startMonth)
                            }
                            if (startDay < 10) {
                                startDay += 1
                                startZeroDay = "0"+startDay
                            } else {
                                startZeroDay = Integer.toString(startDay + 1)
                            }
                            if (finishMonth < 10) {
                                finishZeroMonth = "0"+finishMonth
                            } else {
                                finishZeroMonth = Integer.toString(finishMonth)
                            }
                            if (finishDay < 10) {
                                finishDay += 1
                                finishZeroDay = "0"+finishDay
                            } else {
                                finishZeroDay = Integer.toString(finishDay + 1)
                            }
                            val startMonthStr = startYear.toString() + ". " + startZeroMonth + ". " + startZeroDay
                            val finishMonthStr = finishYear.toString() + ". " + finishZeroMonth + ". " + finishZeroDay
                            invite_range_tv.setText(startMonthStr + " ~ " + finishMonthStr)
                        }
                    })
                    pd.show(getFragmentManager(), "YearMonthPickerTest")


                }
        }



    }
}
