package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitTest(View view) {
        // Figure out if the user has answered question one
        CheckBox one_a_Checkbox = findViewById(R.id.One_a);
        boolean hasOne_a = one_a_Checkbox.isChecked();

        CheckBox one_b_Checkbox = findViewById(R.id.One_b);
        boolean hasOne_b = one_b_Checkbox.isChecked();

        CheckBox one_c_Checkbox = findViewById(R.id.One_c);
        boolean hasOne_c = one_c_Checkbox.isChecked();

        CheckBox one_d_Checkbox = findViewById(R.id.One_d);
        boolean hasOne_d = one_d_Checkbox.isChecked();

        // Figure out if the user has answered question two
        RadioButton two_c_Radiobutton = findViewById(R.id.Two_c);
        boolean hasTwo_c = two_c_Radiobutton.isChecked();

        CheckBox three_a_Checkbox = findViewById(R.id.Three_a);
        boolean hasThree_a = three_a_Checkbox.isChecked();

        CheckBox three_b_Checkbox = findViewById(R.id.Three_b);
        boolean hasThree_b = three_b_Checkbox.isChecked();

        CheckBox three_c_Checkbox = findViewById(R.id.Three_c);
        boolean hasThree_c = three_c_Checkbox.isChecked();

        CheckBox three_d_Checkbox = findViewById(R.id.Three_d);
        boolean hasThree_d = three_d_Checkbox.isChecked();

        // Figure out if the user has answered question four
        RadioButton four_b_Radiobutton = findViewById(R.id.Four_b);
        boolean hasFour_b = four_b_Radiobutton.isChecked();

        // Figure out if the user has answered question five
        CheckBox five_a_Checkbox = findViewById(R.id.Five_a);
        boolean hasFive_a = five_a_Checkbox.isChecked();

        CheckBox five_b_Checkbox = findViewById(R.id.Five_b);
        boolean hasFive_b = five_b_Checkbox.isChecked();

        CheckBox five_c_Checkbox = findViewById(R.id.Five_c);
        boolean hasFive_c = five_c_Checkbox.isChecked();

        CheckBox five_d_Checkbox = findViewById(R.id.Five_d);
        boolean hasFive_d = five_d_Checkbox.isChecked();

        // Figure out if the user has answered question six
        RadioButton six_b_Radiobutton = findViewById(R.id.Six_b);
        boolean hasSix_b = six_b_Radiobutton.isChecked();

        // Figure out if the user has answered question seven
        RadioButton seven_c_Radiobutton = findViewById(R.id.Seven_c);
        boolean hasSeven_c = seven_c_Radiobutton.isChecked();
//        seven_c_Radiobutton.setChecked(false);

        // Figure out if the user has answered question eight
        RadioButton eight_c_Radiobutton = findViewById(R.id.Eight_c);
        boolean hasEight_c = eight_c_Radiobutton.isChecked();

        // Figure out the name of the user from input field
        EditText nameField = findViewById(R.id.name_field);
        String user_name = nameField.getText().toString();

        int score = calculateScore(hasOne_a, hasOne_b, hasOne_c, hasOne_d, hasTwo_c, hasThree_a, hasThree_b, hasThree_c, hasThree_d, hasFour_b,
                hasFive_a, hasFive_b, hasFive_c, hasFive_d, hasSix_b, hasSeven_c, hasEight_c);

        if (score > 20) {
            Toast.makeText(this, "Congratulations " + user_name + "you have " + score + " /40 points!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Good trial " + user_name + "you have " + score + " /40 points", Toast.LENGTH_SHORT).show();
            //finish();
        }
    }

    /**
     * Calculates the score of the user
     *
     * @param One_a   whether or not the user chose One(a)
     * @param One_b   whether or not the user chose One(b)
     * @param One_c   whether or not the user chose One(c)
     * @param One_d   whether or not the user chose One(d)
     * @param Two_c   whether or not the user chose Two(c)
     * @param Three_a whether or not the user chose Three(a)
     * @param Three_b whether or not the user chose Three(b)
     * @param Three_c whether or not the user chose Three(c)
     * @param Three_d whether or not the user chose Three(d)
     * @param Four_b  whether or not the user chose Four(b)
     * @param Five_a  whether or not the user chose Five(a)
     * @param Five_b  whether or not the user chose Five(b)
     * @param Five_c  whether or not the user chose Five(c)
     * @param Five_d  whether or not the user chose Five(d)
     * @param Six_b   whether or not the user chose Six(b)
     * @param Seven_c whether or not the user chose Seven(c)
     * @param Eight_c whether or not the user chose Eight(c)
     * @return total score
     */
    private int calculateScore(boolean One_a, boolean One_b, boolean One_c, boolean One_d, boolean Two_c, boolean Three_a, boolean Three_b,
                               boolean Three_c, boolean Three_d, boolean Four_b,
                               boolean Five_a, boolean Five_b, boolean Five_c, boolean Five_d, boolean Six_b, boolean Seven_c, boolean Eight_c) {

        int baseScore = 0;

        // add 0 points if user chooses all choices
        if (One_a && One_c && (One_b && One_d)) {
            baseScore += 0;
        }
        // add 0 points if user chooses a and c plus a or c
        else if (One_a && One_c && (One_b || One_d)) {
            baseScore += 0;
        } else if (One_a && One_c) {
            baseScore += 5;
        }
        // if choices a or c are chosen plus wrong answers
        else if (One_a || One_c && (One_b && One_d)) {
            baseScore += 0;
        }
        if (Two_c) {
            baseScore += 5;
        }
        if (Three_c && Three_d && (Three_b && Three_a)) {
            baseScore += 0;
        }
        // add 0 points if user chooses a and c plus a or c
        else if (Three_c && Three_d && (Three_b || Three_a)) {
            baseScore += 0;
        } else if (Three_c && Three_d) {
            baseScore += 5;
        }
        // if choices c or d are chosen plus wrong answers
        else if (Three_c || Three_d && (Three_b && Three_a)) {
            baseScore += 0;
        }
        if (Four_b) {
            baseScore += 5;
        }
        // if choices a or c are chosen plus wrong answers
        if (Five_a && Five_c && Five_d && Five_b) {
            baseScore += 0;
        } else if (Five_a && Five_c && Five_d) {
            baseScore += 5;
        }
        if (Six_b) {
            baseScore += 5;
        }
        if (Seven_c) {
            baseScore += 5;
        }
        if (Eight_c) {
            baseScore += 5;
        }
        //finish();
        return baseScore;
    }
}
