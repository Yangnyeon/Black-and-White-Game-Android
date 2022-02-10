package com.example.java_black_and_white_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class game extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    TextView mescore, comscore, menumber, meedit, text1 ;
    EditText edit ;
    Button select ;
    int meNUMBER = 0;
    int comNUMBER = 0;
    int q = 0 ;
    int comturn ;
    SwipeRefreshLayout swipe;
    Random random = new Random();
    ArrayList com = new ArrayList();
    ArrayList me = new ArrayList();
    ArrayList Exception = new ArrayList();
    ArrayList meException = new ArrayList();

    @SuppressWarnings("ALL")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        mescore = findViewById(R.id.mescore);
        comscore = findViewById(R.id.comscore);
        menumber = findViewById(R.id.menumber);
        //comnunber = findViewById(R.id.comnumber);
        //comedit = findViewById(R.id.comedit);
        edit = findViewById(R.id.edit);
        select = findViewById(R.id.select);
        meedit = findViewById(R.id.meedit);
        swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(this);
        text1 = findViewById(R.id.text1);



        for(int i = 0 ; i <= 9 ; i++) {
            me.add(i);
            com.add(i);
        }



        menumber.setText(String.valueOf(me));


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int meturn = Integer.parseInt(edit.getText().toString());
                    if (!meException.contains(meturn)) {
                        meException.add(meturn);
                        me.remove(new Integer(meturn));
                    } else {
                        Toast.makeText(getApplicationContext(), "이미 입력한 숫자입니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    while (Exception.size() < 1 + q) {
                        comturn = random.nextInt(10);
                        if (!Exception.contains(comturn)) {
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
                    //comedit.setText("컴퓨터가 입력한 숫자 : " + comturn);
                    mescore.setText(String.valueOf(meNUMBER));
                    comscore.setText(String.valueOf(comNUMBER));
                    menumber.setText(String.valueOf(me));
                    //comnunber.setText(String.valueOf(com));
                    q++;
                    edit.setText("");
                    if (me.size() == 0) {
                        menumber.setText("게임종료");
                        //comnunber.setText("게임종료");
                        select.setEnabled(false);
                        text1.setText("");
                        meedit.setText("내가 입력한 숫자 : " + meturn + "\n" + "다시하기를 원할시 화면 밑으로 스와이프 하십시오.");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "알맞은 숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    q--;
                }
            }
        });
    }

    @Override
    public void onRefresh() {

        updateLayoutView();


        swipe.setRefreshing(false);
    }

    public void updateLayoutView(){
        edit.setText("");
        q = 0 ;
        meNUMBER = 0 ;
        comNUMBER = 0 ;
        me.clear();
        com.clear();
        Exception.clear();
        meException.clear();
        for(int i = 0 ; i <= 9 ; i++) {
            me.add(i);
            com.add(i);
        }
        menumber.setText(String.valueOf(me));
        mescore.setText(String.valueOf(meNUMBER));
        comscore.setText(String.valueOf(comNUMBER));
        meedit.setText("");
        select.setEnabled(true);
        text1.setText("내가현재 가지고있는 숫자");
    }


}

                //<TextView
                //android:layout_width="match_parent"
                       // android:layout_height="wrap_content"
                       // android:text="숫자"
                       // android:textSize="20sp"
                      //  android:id="@+id/comnumber"
                      //  android:textColor="#FFFFFF"
                      //  ></TextView>