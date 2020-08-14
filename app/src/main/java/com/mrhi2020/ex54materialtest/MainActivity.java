package com.mrhi2020.ex54materialtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.iv);
        //Glide Library
        Glide.with(this).load("https://pgnqdrjultom1827145.cdn.ntruss.com/img/7f/a2/7fa25e94ce0262f82418e9d2f9a3f576dc87dc3907ab2e2dd5c614a33c764e5f_v1.jpg").into(iv);

        inputLayout= findViewById(R.id.layout_et);
        inputLayout.setCounterEnabled(true);
        inputLayout.setCounterMaxLength(10);

        //EditText의 inputType이 password 일때..
        inputLayout.setPasswordVisibilityToggleEnabled(true);

        TextInputEditText et= findViewById(R.id.et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.toString().contains("#") ){
                    inputLayout.setError("특수문자 사용금지");
                }else{
                    inputLayout.setError(null);
                }

                if( s.length() ==0 ) inputLayout.clearFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
