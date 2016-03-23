package com.kronos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
распарсить данные о погоде с этого ресурса
2МЯ СПОСОБАМИ (XML+JSON, XML Pull + XML Simple) в 2 активити со списками
Данные на свое усмотрение.
Список - кастомный (каследник от BaseAdapter)
 */

public class MainActivity extends AppCompatActivity {
    private Button btnPullParse = null;
    private Button btnSimpleParse = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPullParse = (Button) findViewById(R.id.btnGetXMLPull);
        btnPullParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PullActivity.class);
                startActivity(intent);
            }
        });

        btnSimpleParse = (Button) findViewById(R.id.btnGetXMLSimple);
        btnSimpleParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
                startActivity(intent);
            }
        });
    }
}
