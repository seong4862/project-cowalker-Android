package com.jemcom.cowalker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.message.template.ButtonObject;
import com.kakao.message.template.ContentObject;
import com.kakao.message.template.FeedTemplate;
import com.kakao.message.template.LinkObject;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.util.helper.log.Logger;

public class Invite2Activity extends AppCompatActivity {
    String url = "https://cdn.xl.thumbs.canstockphoto.com/computer-generated-3d-image-cooperation-stock-illustrations_csp2074347.jpg";
    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private EditText edit;
    private Button button;
    private Button confirmBtn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite2);

        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
            }
        }else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(Color.BLACK);
        }


        mLayout = (LinearLayout) findViewById(R.id.linearLayout2);
        mEditText = (EditText) findViewById(R.id.editText2);
        mButton = (Button) findViewById(R.id.button2);
        confirmBtn = (Button) findViewById(R.id.invite2_confirm_btn);

        button = new Button(this);
        count=1;


        confirmBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Invite2Activity.this, MainActivity.class);
                //startActivity(intent);
                sendLink();
            }
        });


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=1;
                Log.v("Asdf","count값은 "+count);
                mButton.setVisibility(View.GONE);
                mLayout.addView(createNewTextView(count));
                mLayout.addView(createNewEditText());
                mLayout.addView(createNewButton());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                count+=1;
                Log.v("Asdf","count값은 "+count);
                mLayout.removeView(button);
                mLayout.addView(createNewTextView(count));
                mLayout.addView(createNewEditText());
                mLayout.addView(createNewButton());
            }
        });


    }


    private TextView createNewTextView(int i) {
        final LinearLayout.LayoutParams tvparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        tvparams.setMargins(62,50, 0, 0);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(tvparams);
        textView.setText("질문 " + i);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);

        return textView;
    }

    private void sendLink() {
        FeedTemplate params = FeedTemplate
                .newBuilder(ContentObject.newBuilder("공공서비스 어플리케이션 공모전",
                        url,
                        LinkObject.newBuilder().setWebUrl("")
                                .setMobileWebUrl("").build())
                        .setDescrption("이충엽님이 당신을 추천하셨습니다. 함께 해주세요!")
                        .build())
                .addButton(new ButtonObject("깅스앱으로 열기", LinkObject.newBuilder()
                        .setWebUrl("'https://developers.kakao.com")
                        .setMobileWebUrl("'https://developers.kakao.com")
                        .setAndroidExecutionParams("key1=value1")
                        .setIosExecutionParams("key1=value1")
                        .build()))
                .build();

        KakaoLinkService.getInstance().sendDefault(this, params, new ResponseCallback<KakaoLinkResponse>() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                Logger.e(errorResult.toString());
            }

            @Override
            public void onSuccess(KakaoLinkResponse result) {

            }
        });

    }

    private EditText createNewEditText() {


        final LinearLayout.LayoutParams editparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 110);
        edit = new EditText(this);
        editparams.setMargins(40,27, 40, 0);
        //lparams2.height=35;
        edit.setLayoutParams(editparams);
        edit.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));

        return edit;
    }

    private Button createNewButton() {
        final LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(135, 135);
        btnparams.setMargins(0,30, 0, 0);getActionBar();
        btnparams.gravity = Gravity.CENTER;
        button.setLayoutParams(btnparams);
        button.setBackground(getResources().getDrawable(R.drawable.invite_second_plus_img));

        return button;
    }
}
