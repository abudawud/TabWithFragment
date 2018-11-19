package project.envoss.com.calculatorbalok.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.R;

public class BoardActivity extends AppCompatActivity {
    private final int QUIZ_REQUEST = 1;
    final String TAG = "X-LOG";

    private Button openQuiz;
    private TextView myScor;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        openQuiz = findViewById(R.id.open_quiz);
        myScor = findViewById(R.id.score_board);

        context = this;

        openQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QuizActivity.class);
                startActivityForResult(intent, QUIZ_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case QUIZ_REQUEST:{
                if(resultCode == RESULT_OK){
                    Log.d(TAG, "onActivityResult: " + data.getExtras().getInt("SCORE"));
                    myScor.setText(String.valueOf(data.getExtras().getInt("SCORE")));
                }
            }
        }
    }
}
