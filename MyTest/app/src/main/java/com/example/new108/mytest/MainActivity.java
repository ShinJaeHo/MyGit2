package com.example.new108.mytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    private TextView txtName;
    private Handler mHandler;
    private Runnable mRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // strings.xml 에서 이름 얻기
        String strName = getString(R.string.my_name);

        // key value 저장 객체 얻기
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                getString(R.string.sp_name), Context.MODE_PRIVATE
        );

        // 이름 저장
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SP_MY_NAME", strName);


        editor.commit();

        // TextView에 이름 표현
        txtName = (TextView)findViewById(R.id.txt_name);
        txtName.setText(strName);


    }

    @Override
    protected void onResume() {
        super.onResume();

        // 딜레이 이후 ListActivity로 이동 ㄴ
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 3000);
    }

    @Override
    protected void onDestroy() {
        Log.d("MyTest", "onDstory()");
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }
}
