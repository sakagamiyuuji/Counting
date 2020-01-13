package com.e.counting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //pembuatan object component
    TextView tvCount;
    Button btnCount, btnReset;
    int count = 990;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //bind activity ke layout yang akan di tampilkan

        //binding compenent ke view
        tvCount =findViewById(R.id.tv_count);
        btnCount=findViewById(R.id.btn_count);
        btnReset=findViewById(R.id.btn_reset);

        //cara 1 untuk setOnClick
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something here
                count++;
                if(count>999){
                    tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelSize(R.dimen.smallerText_tvCount));
                }
                tvCount.setText(String.valueOf(count));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setText(String.valueOf(count));
            }
        });

        if(savedInstanceState != null){
            count=savedInstanceState.getInt("state_count");
            if (count>999){
                tvCount.setTextSize(0,getResources().getDimensionPixelSize(R.dimen.smallerText_tvCount));
            }
            tvCount.setText(String.valueOf(count));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("state_count",count);


    }

}
