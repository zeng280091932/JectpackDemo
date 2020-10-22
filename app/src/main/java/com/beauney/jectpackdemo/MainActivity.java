package com.beauney.jectpackdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    MyViewModel myViewModel;
//    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        mTextView = findViewById(R.id.textView);
        mTextView.setText(String.valueOf(myViewModel.number));

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                mTextView.setText(String.valueOf(myViewModel.number));
//                number++;
//                mTextView.setText(String.valueOf(number));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number += 2;
                mTextView.setText(String.valueOf(myViewModel.number));

//                number += 2;
//                mTextView.setText(String.valueOf(number));
            }
        });
    }
}
