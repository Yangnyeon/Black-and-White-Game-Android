package com.example.java_black_and_white_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mescore, comscore, menumber, comnunber, comedit, meedit ;
    EditText edit ;
    Button select ;
    int meNUMBER = 0;
    int comNUMBER = 0;
    int q = 0 ;
    int comturn ;

    @SuppressWarnings("ALL")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mescore = findViewById(R.id.mescore);
        comscore = findViewById(R.id.comscore);
        menumber = findViewById(R.id.menumber);
        comnunber = findViewById(R.id.comnumber);
        comedit = findViewById(R.id.comedit);
        edit = findViewById(R.id.edit);
        select = findViewById(R.id.select);
        meedit = findViewById(R.id.meedit);



        Random random = new Random();
        ArrayList com = new ArrayList();
        ArrayList me = new ArrayList();
        ArrayList Exception = new ArrayList();




        for(int i = 0 ; i <= 9 ; i++) {
            me.add(i);
            com.add(i);
        }



        menumber.setText(String.valueOf(me));
        comnunber.setText(String.valueOf(com));


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int meturn = Integer.parseInt(edit.getText().toString());
                me.remove(new Integer(meturn));

                while(Exception.size() < 1 + q) {
                    comturn = random.nextInt(10);
                    if(!Exception.contains(comturn)) {
                        Exception.add(comturn);
                        com.remove(new Integer(comturn));
                    }
                }

                if (meturn > comturn) {
                        meNUMBER++;
                } else if (meturn < comturn) {
                        comNUMBER++;
                }
                    meedit.setText("내가 입력한 숫자 : " + meturn);
                    comedit.setText("컴퓨터가 입력한 숫자 : " + comturn);
                    mescore.setText(String.valueOf(meNUMBER));
                    comscore.setText(String.valueOf(comNUMBER));
                    menumber.setText(String.valueOf(me));
                    comnunber.setText(String.valueOf(com));
                    q++;
            }
        });
    }
}