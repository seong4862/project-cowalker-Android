package com.jemcom.cowalker;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;




public class ProjectCreate2Activity extends AppCompatActivity {

    Intent CropIntent ;
    private LinearLayout mLayout;
    private ImageView imgButton;
    private ImageView btn;
    Context context;
    int count=1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_create2);

        mLayout = (LinearLayout) findViewById(R.id.create_project2_layout);
        final LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(500, 500);
        btnparams.setMargins(20,0, 0, 0);getActionBar();
        Button confirmBtn = (Button) findViewById(R.id.create2_confirm_btn);
        context=this;
        final Button defaultBtn = new Button(context);
        defaultBtn.setBackground(getResources().getDrawable(R.drawable.project_default_img));
        mLayout.addView(defaultBtn);

       // mLayout.addView(createNewButton());
       // mLayout.addView(createNewButton());
       // mLayout.addView(createNewButton());

        defaultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v("사진 입력","사진 입력");
                Intent GalIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(GalIntent, "Select Image From Gallery"), 2);


                btn = new ImageView(context);
                //btn.setText("버튼"+String.valueOf(count));
                final LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(500, 500);
                btnparams.setMargins(20,0, 0, 0);getActionBar();
                btn.setLayoutParams(btnparams);
                btn.setScaleType(ImageView.ScaleType.FIT_XY);

                mLayout.removeView(defaultBtn);
                mLayout.addView(btn);

                final LinearLayout.LayoutParams plusBtnparams = new LinearLayout.LayoutParams(500, 500);
                plusBtnparams.setMargins(20,0, 0, 0);getActionBar();
                defaultBtn.setLayoutParams(plusBtnparams);
                defaultBtn.setBackground(getResources().getDrawable(R.drawable.project_default_img));
                mLayout.addView(defaultBtn);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectCreate2Activity.this, InviteActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {

            ImageCropFunction();

        }
        else if (requestCode == 2) {

            if (data != null) {
                uri = data.getData();


                ImageCropFunction();

            }
        }
        else if (requestCode == 1) {

            if (data != null) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = bundle.getParcelable("data");
                btn.setImageBitmap(bitmap);
            }
        }
    }


    public void ImageCropFunction() {

        // Image Crop Code
        try {
            CropIntent = new Intent("com.android.camera.action.CROP");

            CropIntent.setDataAndType(uri, "image/*");

            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 500 );
            CropIntent.putExtra("outputY", 500);
            CropIntent.putExtra("aspectX", 50);
            CropIntent.putExtra("aspectY", 50);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);

            startActivityForResult(CropIntent, 1);

        } catch (ActivityNotFoundException e) {

        }
    }

    private ImageView createNewButton()
    {
        imgButton = new ImageView(context);
        final LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(500, 500);
        imgButton.setLayoutParams(btnparams);
        imgButton.setBackground(getResources().getDrawable(R.drawable.invite_second_plus_img));
        //imgButton.setText(count);
        count++;
        return imgButton;
    }

}
