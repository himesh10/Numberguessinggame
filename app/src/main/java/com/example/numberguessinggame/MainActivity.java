package com.example.numberguessinggame;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity<questions> extends AppCompatActivity {

    int score = 0;

    EditText et_guess;

    public int roll_the_dice() {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        return randomNumber;

    }

    public void guess(View view) {

        int Number = roll_the_dice();

        et_guess = findViewById(R.id.et_guess);
        Integer guessNumber = Integer.parseInt(et_guess.getText().toString());
        String message = " ";
        if (Number != guessNumber) {
            message = "Incorrect, the number was: " + Number;

        } else {
            message = "Congratulations!";

            score = score + 1;

            TextView tv = this.findViewById(R.id.textView);

            tv.setText("Score: " + score);

        }

        Log.i("Random Number", Integer.toString(Number));
        Log.i("Guess Number", et_guess.getText().toString());

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }
        public void word(View view) {

            ArrayList <String> word = new ArrayList<>();

            int index = 0;

            word.add("If you could go anywhere in the world, where would you go?");
            word.add("If you were stranded on a desert island, what three things would you want to take with you?");
            word.add("If you could eat only one food for the rest of your life, what would that be?");
            word.add("If you won a million dollars, what is the first thing you would buy?");
            word.add("If you could spend the day with one fictional character, who would it be?");
            word.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

            TextView wordView = this.findViewById(R.id.textView4);

            wordView.setText(word.get(roll_the_dice()-1));


        }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        startActivity(intent);
    }

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
