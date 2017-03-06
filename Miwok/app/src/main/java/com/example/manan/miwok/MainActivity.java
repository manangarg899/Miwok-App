package com.example.manan.miwok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView numbers = (TextView)findViewById(R.id.numbers);

        numbers.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent numberIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numberIntent);

            }


        });




        TextView colors = (TextView)findViewById(R.id.colors);

        colors.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent colorIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorIntent);

            }


        });


        TextView phrases = (TextView)findViewById(R.id.phrases);

        phrases.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent phraseIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phraseIntent);

            }


        });




        TextView family = (TextView)findViewById(R.id.family);

        family.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);

            }


        });












    }






}
