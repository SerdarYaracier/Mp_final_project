package com.example.cteam;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class civvv6 extends AppCompatActivity implements View.OnClickListener {


    EditText P1_name, P2_name;
    TextView P1_txt, P2_txt, Score1, Score2;

    Boolean oynuyor;
    int roundCounter;
    int S1C, S2C;


    int[] durum = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] kazandirir = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}


    };

    Button[] bas_but = new Button[9];


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civvv6);


        Button start;
        Button btnRestart;

        btnRestart = findViewById(R.id.btn_restart);

        P2_txt = findViewById(R.id.textView3);
        P1_txt = findViewById(R.id.textView);
        Score1 = findViewById(R.id.textView4);
        Score2 = findViewById(R.id.Score2);

        P2_name = findViewById(R.id.editTextTextPersonName2);
        P1_name = findViewById(R.id.editTextTextPersonName);
        start = findViewById(R.id.btn_start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                P1_txt.setText(P1_name.getText());
                P1_name.setText("X Oyuncusu");
                Score1.setText("0");

                P2_txt.setText(P2_name.getText());
                P2_name.setText("O Oyuncusu");
                Score2.setText("0");


            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P2_txt.setText("");
                P1_txt.setText("");
                Score1.setText("");
                Score2.setText("");
                S1C = 0;
                S2C = 0;
                P2_name.setText("");
                P1_name.setText("");

            }
        });

        for (int i = 0; i < bas_but.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            bas_but[i] = findViewById(resourceID);
            bas_but[i].setOnClickListener(this);


        }


        oynuyor = true;


    }

    @Override
    public void onClick(View v) {

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));

        if (oynuyor) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#FFC34A"));

            durum[gameStatePointer] = 0;
        } else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#FFFF00"));
            durum[gameStatePointer] = 1;
        }
        roundCounter++;

        if (KazananKont()) {
            if (oynuyor) {
                S1C++;
                updatePlayerScore();
                Toast.makeText(this, "Oyuncu "+P1_txt.getText()+" Kazandı", Toast.LENGTH_SHORT).show();
                playAgain();
            } else {
                S2C++;
                updatePlayerScore();
                Toast.makeText(this, "Oyuncu "+P2_txt.getText()+" Kazandı", Toast.LENGTH_SHORT).show();
                playAgain();

            }
        } else if (roundCounter == 9) {
            playAgain();
            Toast.makeText(this, "Kazanan yok", Toast.LENGTH_SHORT).show();


        } else {
            oynuyor = !oynuyor;
        }

    }

    public Boolean KazananKont() {

        boolean winnerResult = false;
        for (int[] kazandirir : kazandirir) {

            if (durum[kazandirir[0]] == durum[kazandirir[1]] && durum[kazandirir[1]] == durum[kazandirir[2]] &&
                    durum[kazandirir[0]] != 2) {

                winnerResult = true;
            }

        }
        return winnerResult;
    }

    public void updatePlayerScore() {
        Score1.setText(Integer.toString(S1C));
        Score2.setText(Integer.toString(S2C));

    }

    public void playAgain() {
        roundCounter = 0;
        oynuyor = true;

        for (int i = 0; i < bas_but.length; i++) {
            durum[i] = 2;
            bas_but[i].setText("");
        }
    }



}