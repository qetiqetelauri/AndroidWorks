package com.razormist.simplequizapp;

/**
 * Created by Arvin on 2/21/2018.
 */

public class Question {

    public String questions[] = {
            "1+1",
            "1+2",
            "1+3",
            "1+4",
            "1+5",
            "1+6",
            "1+7",
            "1+8"
    };

    public String choices[][] = {
            {"1", "2", "3", "4"},
            {"2 ", "3", "4", "5 "},
            {"4 ", "3 ", "5 ", "6"},
            {"2 ", "3", "4", "5 "},
            {"5 ", "3", "4", "6 "},
            {"6 ", "3", "7", "5 "},
            {"2 ", "8", "4", "5 "},
            {"2 ", "3", "9", "5 "}
    };

    public String correctAnswer[] = {
        "2",
        "3",
        "4",
            "5",
            "6",
            "7",
            "8",
            "9",
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
