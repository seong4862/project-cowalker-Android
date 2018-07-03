package com.jemcom.cowalker;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InviteSecondActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private EditText edit;
    private Button button;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_second);

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
        // mButton.setOnClickListener(onClick());
        //button.setOnClickListener(onClick());
        TextView textView = new TextView(this);
        textView.setText("New text");
        button = new Button(this);
        count=1;
        Log.v("Asdf","count값은 "+count);
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
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("질문 " + i);

        return textView;
    }

    private EditText createNewEditText() {


        final LinearLayout.LayoutParams lparams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        edit = new EditText(this);
        lparams2.setMargins(11,13, 13, 0);
        //lparams2.height=35;
        edit.setLayoutParams(lparams2);
        edit.setBackgroundColor(this.getResources().getColor(R.color.colorBackground));

        //dd
        // edit.setLayoutParams(new LinearLayout.LayoutParams(Linear.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        // layout.addView(edict);
        return edit;
    }

    private Button createNewButton() {


        final LinearLayout.LayoutParams lparams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        button.setText("질문 추가");
        lparams3.setMargins(11,13, 13, 0);
        //lparams2.height=35;
        button.setLayoutParams(lparams3);

        return button;
    }
}
