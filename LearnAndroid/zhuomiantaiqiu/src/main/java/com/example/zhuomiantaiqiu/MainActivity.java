package com.example.zhuomiantaiqiu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_main); // 删除默认的布局管理器
//         创建帧布局管理器
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(R.drawable.jiedao);
//        添加帧布局管理器到activity当中
        setContentView(frameLayout);

        TextView text1 = new TextView(this);
        text1.setText("开始游戏");
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        text1.setTextColor(Color.rgb(17,85,144));

//        设置text1布局居中
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        text1.setLayoutParams(params);
//        设置text1点击事件监听
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("温馨提示")
                        .setMessage("游戏有风险，进入需谨慎，真的要进入吗")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("桌面台球","进入游戏");
                            }
                        }).setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("桌面台球","退出游戏");
                        finish(); // 结束当前 activity
                    }
                }).show();
            }
        });
//        文本框组件添加到布局管理器当中
        frameLayout.addView(text1);

    }
}
