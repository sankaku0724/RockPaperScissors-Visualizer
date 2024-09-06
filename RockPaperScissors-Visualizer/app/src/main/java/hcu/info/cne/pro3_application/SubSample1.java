package hcu.info.cne.pro3_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubSample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sample1);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);

        Intent i = this.getIntent();
        int count = i.getIntExtra("count",0);
        int win_count = i.getIntExtra("win_count",0);
        int lose_count = i.getIntExtra("lose_count",0);
        int draw_count = i.getIntExtra("draw_count",0);

        Button bt = findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

        textView.setText("対戦回数："+count+"回");
        textView2.setText("勝利回数："+win_count+"回");
        textView3.setText("敗北回数："+lose_count+"回");
        textView4.setText("あいこ回数："+draw_count+"回");

    }
}