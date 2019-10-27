package com.example.numberguessinggame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    EditText et_guess;
    int randomNumber;

    public void random() {
        Random random = new Random();
        randomNumber = random.nextInt(6) + 1;

    }

    public void guess(View view) {
    et_guess = findViewById(R.id.et_guess);
    Integer guessNumber = Integer.parseInt(et_guess.getText().toString());
    String message = " ";
    if (randomNumber < guessNumber) {
        message = "Try lower";
    } else if (randomNumber > guessNumber) {
        message = "Try higher";

    } else message = "Congratulations!";


        Log.i("Random Number", Integer.toString(randomNumber));
        Log.i("Guess Number", et_guess.getText().toString());

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random();
    }

}
