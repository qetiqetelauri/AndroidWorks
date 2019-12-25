package com.example.midterm2_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int score = 100;
    private String[][] a;
    public Button n1;
    public Button n2;
    public Button n3;
    public Button n4;
    public Button n5;
    public Button n6;
    public Button n7;
    public Button n8;
    public Button n9;
    public boolean Game = false;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenerateInt();
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        screen = findViewById(R.id.calculatorscreen);
        ChangeButton(a);

    }

    public void onClick(View v) {

        if(Game){
            switch (v.getId()) {
                case R.id.n1:
                case R.id.n9:
                case R.id.n2:
                case R.id.n3:
                case R.id.n4:
                case R.id.n5:
                case R.id.n6:
                case R.id.n7:
                case R.id.n8:
                    GenerateInt();
                    ChangeButton(a);
                    Game=false;
                    break;
            }
        }{
            switch (v.getId()) {
                case R.id.n1:

                    Generate();
                    ChangeButton(a);
                    check(1);

                    break;

                case R.id.n2:

                    Generate();
                    ChangeButton(a);
                    check(2);

                    break;
                case R.id.n3:

                    Generate();
                    ChangeButton(a);
                    check(3);

                    break;
                case R.id.n4:

                    Generate();
                    ChangeButton(a);
                    check(4);

                    break;
                case R.id.n5:

                    Generate();
                    ChangeButton(a);
                    check(5);

                    break;
                case R.id.n6:

                    Generate();
                    ChangeButton(a);
                    check(6);

                    break;
                case R.id.n7:

                    Generate();
                    ChangeButton(a);
                    check(7);

                    break;
                case R.id.n8:

                    Generate();
                    ChangeButton(a);
                    check(8);
                    break;
                case R.id.n9:

                    Generate();
                    ChangeButton(a);
                    check(9);
                    break;


            }
            Game=true;
        }

    }

    public void Generate() {
        String[] vowels = {"W", "L", "N"};
        Random r = new Random();
        a = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = vowels[r.nextInt(3)];
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }

    public void GenerateInt() {
        int k = 1;
        a = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = String.valueOf(k);
                k = k + 1;
            }

        }
    }
    public void check(int num){
        switch (num) {
            case 1:
                if(a[0][0] == "N"){
                    score=score-1;
                }else {
                    if (a[0][0] == "W") {
                        score = score + 5;
                        if (a[0][1] == "W") {
                            score = score + 5;
                        } else {
                            if (a[1][0] == "W") {
                                score = score + 5;
                            }
                        }
                    } else {
                        score = score - 5;
                        if (a[0][1] == "L") {
                            score = score - 5;
                        }
                         if (a[1][0] == "L") {
                                score = score - 5;
                            }


                    }
                }
                break;
            case 2:
                if(a[0][1] == "N"){
                    score=score-1;
                }else {
                    if (a[0][1] == "W") {
                        score = score + 5;
                        if (a[0][2] == "W") {
                            score = score + 5;
                        }
                        if (a[0][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][0] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[0][1] == "L") {
                            score = score - 5;
                            if (a[0][2] == "L") {
                                score = score - 5;
                            }
                            if (a[0][1] == "L") {
                                score = score - 5;
                            }
                            if (a[1][0] == "L") {
                                score = score - 5;
                            }
                        }
                    }
                }
                break;
            case 3:
                if(a[0][2] == "N"){
                    score=score-1;
                }else {
                    if (a[0][2] == "W") {
                        score = score + 5;
                        if (a[0][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][1] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[0][2] == "L") {
                            score = score - 5;
                            if (a[0][1] == "L") {
                                score = score - 5;
                            }
                            if (a[1][1] == "L") {
                                score = score - 5;
                            }

                        }
                    }
                }
                break;
            case 4:
                if(a[1][0] == "N"){
                    score=score-1;
                }else {
                    if (a[1][0] == "W") {
                        score = score + 5;
                        if (a[0][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][1] == "W") {
                            score = score + 5;
                        }
                        if (a[2][0] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[1][0] == "L") {
                            score = score - 5;
                            if (a[1][1] == "L") {
                                score = score - 5;
                            }
                            if (a[2][0] == "L") {
                                score = score - 5;
                            }

                        }
                    }
                }
                break;
            case 5:
                if(a[1][1] == "N"){
                    score=score-1;
                }else {
                    if (a[1][1] == "W") {
                        score = score + 5;
                        if (a[0][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][2] == "W") {
                            score = score + 5;
                        }
                        if (a[2][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][0] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[1][1] == "L") {
                            score = score - 5;
                            if (a[1][2] == "L") {
                                score = score - 5;
                            }
                            if (a[0][1] == "L") {
                                score = score - 5;
                            }
                            if (a[2][1] == "L") {
                                score = score - 5;
                            }
                            if (a[1][0] == "L") {
                                score = score - 5;
                            }

                        }
                    }
                }
                break;
            case 6:
                if(a[1][2] == "N"){
                    score=score-1;
                }else {
                    if (a[1][2] == "W") {
                        score = score + 5;
                        if (a[1][1] == "W") {
                            score = score + 5;
                        }
                        if (a[0][2] == "W") {
                            score = score + 5;
                        }
                        if (a[2][2] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[1][2] == "L") {
                            score = score - 5;
                            if (a[0][2] == "L") {
                                score = score - 5;
                            }
                            if (a[1][1] == "L") {
                                score = score - 5;
                            }
                            if (a[2][2] == "L") {
                                score = score - 5;
                            }


                        }
                    }
                }
                break;
            case 7:
                if(a[2][0] == "N"){
                    score=score-1;
                }else {
                    if (a[2][0] == "W") {
                        score = score + 5;
                        if (a[1][0] == "W") {
                            score = score + 5;
                        }
                        if (a[2][1] == "W") {
                            score = score + 5;
                        }


                    } else {
                        if (a[2][0] == "L") {
                            score = score - 5;
                            if (a[1][0] == "L") {
                                score = score - 5;
                            }
                            if (a[2][1] == "L") {
                                score = score - 5;
                            }


                        }
                    }
                }
                break;
            case 8:
                if(a[2][1] == "N"){
                    score=score-1;
                }else {
                    if (a[2][1] == "W") {
                        score = score + 5;
                        if (a[2][0] == "W") {
                            score = score + 5;
                        }
                        if (a[2][2] == "W") {
                            score = score + 5;
                        }
                        if (a[1][1] == "W") {
                            score = score + 5;
                        }



                    } else {
                        if (a[2][1] == "L") {
                            score = score - 5;
                            if (a[2][0] == "L") {
                                score = score - 5;
                            }
                            if (a[1][1] == "L") {
                                score = score - 5;
                            }
                            if (a[2][2] == "L") {
                                score = score - 5;
                            }


                        }
                    }
                }
                break;

            case 9:
                if(a[2][2] == "N"){
                    score=score-1;
                }else {
                    if (a[2][2] == "W") {
                        score = score + 5;
                        if (a[2][1] == "W") {
                            score = score + 5;
                        }
                        if (a[1][2] == "W") {
                            score = score + 5;
                        }




                    } else {
                        if (a[2][2] == "L") {
                            score = score - 5;
                            if (a[2][1] == "L") {
                                score = score - 5;
                            }
                            if (a[1][2] == "L") {
                                score = score - 5;
                            }


                        }
                    }
                }
                break;


        }
        screen.setText(String.valueOf(score));
    }
    public void ChangeButton(String[][] b)
    {
         n1.setText(b[0][0]);
         n2.setText(b[0][1]);
         n3.setText(b[0][2]);
         n4.setText(b[1][0]);
         n5.setText(b[1][1]);
         n6.setText(b[1][2]);
         n7.setText(b[2][0]);
         n8.setText(b[2][1]);
         n9.setText(b[2][2]);
    }

}

