package tech.wangj.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tech.wangj.pickimage.PhotoWallActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view) {
        //跳转至最终的选择图片页面
        Intent intent = new Intent(MainActivity.this, PhotoWallActivity.class);
        startActivity(intent);

    }
}
