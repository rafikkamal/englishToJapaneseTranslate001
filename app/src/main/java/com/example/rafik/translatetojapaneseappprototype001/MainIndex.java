package com.example.rafik.translatetojapaneseappprototype001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*

 */
    public void displayBanglaToJapanese(View view){
        Toast.makeText(this,"displayBanglaToJapanese",Toast.LENGTH_SHORT).show();
    }

    /*

    */
    public void displayEnglishToJapanese(View view){
        //Toast.makeText(this,"displayEnglishToJapanese",Toast.LENGTH_SHORT).show();
        Intent displayEnglishToJapanese_Intent = new Intent(this,EnglishToJapaneseMenu.class);
        startActivity(displayEnglishToJapanese_Intent);
    }

    /*

     */
    public void displayMyProfile(View view){
        Toast.makeText(this,"displayMyProfile",Toast.LENGTH_SHORT).show();
    }


}
