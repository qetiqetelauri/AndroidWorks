package com.example.quiz_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    Button btn_one, btn_two;
    TextView tv_question;

    int questionNumber = 0;
    int correctNumber=0;
    private Question question = new Question();

    private String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btn_one = (Button)findViewById(R.id.btn_one);

        btn_two = (Button)findViewById(R.id.btn_two);



        tv_question = (TextView)findViewById(R.id.tv_question);

        NextQuestion(questionNumber);


        btn_one.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (btn_one.getText() == answer) {


                                               questionNumber = questionNumber + 1;
                                               correctNumber = correctNumber + 1;
                                               NextQuestion(questionNumber);
                                           } else {
                                               questionNumber = questionNumber + 1;
                                               NextQuestion(questionNumber);

                                           }
                                       }
                                   }
        );

        btn_two.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if(btn_two.getText() == answer){


                                               questionNumber=questionNumber+1;
                                               correctNumber=correctNumber+1;
                                               NextQuestion(questionNumber);
                                           }else{

                                               questionNumber=questionNumber+1;
                                               NextQuestion(questionNumber);
                                           }
                                       }
                                   }
        );
    }



    private void GameOver(){

        if(correctNumber>=5){
            Intent intent = new Intent(this, SendActivity.class);
            intent.putExtra("score", correctNumber);
            startActivity(intent);
        }else{
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    private void NextQuestion(int num){
        if(questionNumber==7){
            GameOver();
        }
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));

        answer = question.getCorrectAnswer(num);
    }
}

