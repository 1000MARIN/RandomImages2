package com.example.randomimages2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[] {
            R.drawable.ic_baseline_add_24,
            R.drawable.ic_baseline_heart_24,
            R.drawable.ic_baseline_local_shipping_24,
            R.drawable.ic_baseline_pedal_bike_24,
            R.drawable.ic_baseline_star_24,
            R.drawable.ic_baseline_wb_cloudy_24
    };

    ImageView[] box_be = new ImageView[6];
    ImageView[] box_bl = new ImageView[6];

    int selected[] = new int[6];
    int _view[] = new int[6];

    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box_be[0] = findViewById(R.id.box_be_1);
        box_be[1] = findViewById(R.id.box_be_2);
        box_be[2] = findViewById(R.id.box_be_3);
        box_be[3] = findViewById(R.id.box_be_4);
        box_be[4] = findViewById(R.id.box_be_5);
        box_be[5] = findViewById(R.id.box_be_6);

        box_bl[0] = findViewById(R.id.box_bl_1);
        box_bl[1] = findViewById(R.id.box_bl_2);
        box_bl[2] = findViewById(R.id.box_bl_3);
        box_bl[3] = findViewById(R.id.box_bl_4);
        box_bl[4] = findViewById(R.id.box_bl_5);
        box_bl[5] = findViewById(R.id.box_bl_6);

        int minimumValue = 0;
        int maximumValue = 5;

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        // 처음 그림을 숨긴다
        for (int i = 0; i < 6; i++) {
            box_bl[i].setVisibility(View.INVISIBLE);
        }

        // 이미지 순서 랜덤함수 생성
        for (int i = 0; i < 6; i++) {
            selected[i] =   random.nextInt(maximumValue - minimumValue + 1) + minimumValue;
            for (int j = 0; j < i; j++) {
                if (selected[i] == selected[j]) {
                    i--;
                }
            }
        }

        // 이미지 노출 순서 랜덤
        for (int i = 0; i < 6; i++) {
            _view[i] =   random.nextInt(maximumValue - minimumValue + 1) + minimumValue;
            for (int j = 0; j < i; j++) {
                if (_view[i] == _view[j]) {
                    i--;
                }
            }
        }

        // 이미지 종류 랜덤
        for (int k = 0; k < 6; k++) {
            box_bl[k].setImageResource(images[selected[k]]);
        }

        // 랜덤이미지 노출순서대로 보이기 및 숨기기
        for (int i = 0; i < 6; i++) {
            final Handler handler = new Handler();
            int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    box_bl[_view[finalI]].setVisibility(View.VISIBLE);
                    if ( finalI> 0 )
                        box_bl[_view[finalI - 1 ]].setVisibility(View.INVISIBLE);
                }
            }, 1000*i);
        }

        // 전체 숨기기
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    box_bl[i].setVisibility(View.INVISIBLE);
                }

                // 클릭 이벤트 생성


            }
        }, 6000 );





    }
}




