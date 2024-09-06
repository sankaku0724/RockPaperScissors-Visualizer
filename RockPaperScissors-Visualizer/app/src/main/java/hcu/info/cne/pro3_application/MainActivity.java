package hcu.info.cne.pro3_application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import static hcu.info.cne.pro3_application.R.layout.activity_main;

import java.util.Random;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1, imageView2;
    int count =0;
    int win_count = 0;
    int lose_count = 0;
    int draw_count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, SubSample1.class);
                i.putExtra("count",count);
                i.putExtra("win_count",win_count);
                i.putExtra("lose_count",lose_count);
                i.putExtra("draw_count",draw_count);
                startActivity(i);
            }
        });

        imageView1 = findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.empty);

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.empty);
    }
    // グーが押された時
    public void onClickRock(View view) {
        game(0);
        imageView1.setImageResource(R.drawable.janken_gu);
        count++;
    }
    // チョキが押された時
    public void onClickScissors(View view) {
        game(1);
        imageView1.setImageResource(R.drawable.janken_choki);
        count++;
    }
    // パーが押された時
    public void onClickPaper(View view) {
        game(2);
        imageView1.setImageResource(R.drawable.janken_pa);
        count++;
    }
    private void game(int playerHand) {
        String[] handTexts = { "グー✊", "チョキ✌", "パー✋" };
        // ０以上３未満の乱数を生成してコンピュータの手をランダムに決定
        Random r = new Random();
        int cupHand = r.nextInt(3);
        if (cupHand==0){
            imageView2.setImageResource(R.drawable.janken_gu);
        }
        else if (cupHand==1){
            imageView2.setImageResource(R.drawable.janken_choki);
        }
        else{
            imageView2.setImageResource(R.drawable.janken_pa);
        }

        String judge = null;
        // プレイヤーとコンピュータの手を比較して勝敗を判定する
        if (playerHand == cupHand) {
            judge = "あいこだよ！";
        } else if (playerHand == 0 && cupHand == 2) {
            // 「グー」対「パー」
            judge = "負け！";
        } else if (playerHand == 0 && cupHand == 1) {
            // 「グー」対「チョキ」
            judge = "勝ち！";
        } else if (playerHand == 1 && cupHand == 0) {
            // 「チョキ」対「グー」
            judge = "負け！";
        } else if (playerHand == 1 && cupHand == 2) {
            // 「チョキ」対「パー」
            judge = "勝ち！";
        } else if (playerHand == 2 && cupHand == 0) {
            // 「パー」対「グー」
            judge = "勝ち！";
        } else if (playerHand == 2 && cupHand == 1) {
            // 「パー」対「チョキ」
            judge = "負け！";
        }

        if (judge == "あいこだよ！"){
            draw_count++;
        }else if (judge == "勝ち！"){
            win_count++;
        }else if (judge == "負け！"){
            lose_count++;
        }

        TextView textViewJudge = (TextView)findViewById(R.id.judge);
        textViewJudge.setText(judge);

        TextView textViewCpu = (TextView)findViewById(R.id.cpu);
        textViewCpu.setText("コンピュータは"+handTexts[cupHand]);
    }
}
