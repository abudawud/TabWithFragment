package project.envoss.com.calculatorbalok.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import project.envoss.com.calculatorbalok.R;

public class QuizActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup distros, linux, user, de, iptables;
    private Button submit;

    final String TAG = "X-LOG";
    final int QA_DISTRO = 3;
    final int QA_LINUX = 6;
    final int QA_USER = 7;
    final int QA_IPTABLES = 10;
    final int QA_DE = 16;


    Integer score = 0;
    int [] currentscor = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        distros = findViewById(R.id.distros);
        linux = findViewById(R.id.linux);
        user = findViewById(R.id.user);
        de = findViewById(R.id.de);
        iptables = findViewById(R.id.iptables);
        submit = findViewById(R.id.submmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("SCORE", score);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        distros.setOnCheckedChangeListener(this);
        iptables.setOnCheckedChangeListener(this);
        linux.setOnCheckedChangeListener(this);
        de.setOnCheckedChangeListener(this);
        user.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int rid = radioGroup.getCheckedRadioButtonId();

        Log.d(TAG, "onCheckedChanged: " + rid);
        switch (radioGroup.getId()){
            case R.id.distros:{
                if(rid == R.id.distro_a)
                    currentscor[0] = 20;
                else
                    currentscor[0] = 0;

                break;
            }

            case R.id.linux:{
                if(rid == R.id.linux_a)
                    currentscor[1] = 20;
                else
                    currentscor[1] = 0;

                break;
            }

            case R.id.user:{
                if(rid == R.id.user_a)
                    currentscor[2] = 20;
                else
                    currentscor[2] = 0;

                break;
            }

            case R.id.iptables:{
                if(rid == R.id.iptables_a)
                    currentscor[3] = 20;
                else
                    currentscor[3] = 0;

                break;
            }

            case R.id.de:{
                if(rid == R.id.de_a)
                    currentscor[4] = 20;
                else
                    currentscor[4] = 0;
                break;
            }
        }

        score = 0;
        for(int item : currentscor){
            score += item;
        }

        Log.d(TAG, "score: " + score);
    }
}
