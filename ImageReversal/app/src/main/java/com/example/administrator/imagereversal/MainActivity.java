package com.example.administrator.imagereversal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        img.setDrawingCacheEnabled(true);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setDrawingCacheEnabled(true);
                Bitmap bitmap = img.getDrawingCache();
                Bitmap modBm = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
                Canvas canvas = new Canvas(modBm);
                Paint paint = new Paint();
                Matrix matrix = new Matrix();
                //镜子效果：
                matrix.setScale(-1,1);//翻转
                matrix.postTranslate(bitmap.getWidth(),0);
                canvas.drawBitmap(bitmap,matrix,paint);
                img.setImageBitmap(modBm);
                img.setDrawingCacheEnabled(false);
            }
        });
    }
}
