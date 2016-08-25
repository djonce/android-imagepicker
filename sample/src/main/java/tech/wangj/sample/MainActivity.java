package tech.wangj.sample;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tech.wangjie.imagepicker.PhotoWallActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void doClick(View view) {
        //跳转至最终的选择图片页面
        Intent intent = new Intent(MainActivity.this, PhotoWallActivity.class);
        startActivityForResult(intent, PhotoWallActivity.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String imagePath = data.getStringExtra(PhotoWallActivity.KEY_PATH);

            imageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        }
    }
}
