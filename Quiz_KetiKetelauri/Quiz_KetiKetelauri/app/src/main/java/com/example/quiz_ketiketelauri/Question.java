package com.example.quiz_ketiketelauri;


public class Question {

    public String questions[] = {
            "1+1",
            "1+2",
            "1+3",
            "1+4",
            "1+5",
            "1+6",
            "1+7",
    };

    public String choices[][] = {
            {"1", "2", },
            {"2 ", "3", },
            {"4 ","9"},
            {"2 ", "5 "},
            {"5 ", "6 "},
            { "7", "5 "},
            {"2 ", "8",},
    };

    public String correctAnswer[] = {
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
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


    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
