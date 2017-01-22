package com.example.rafik.translatetojapaneseappprototype001;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EnglishToJapaneseMenuContentDisplay extends AppCompatActivity {

    Bundle englishToJapaneseMenuContentDisplay_Data;
    //EnglishToJapaneseDBHandler E2JDB;
    MyDBHandler myDBHandler;

    public TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_to_japanese_menu_content_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv1 = (TextView)findViewById(R.id.englishSentenceTextView);
        tv1.setText("tv1");
        Log.d("ERROR","\nError (tv1) => "+tv1.getError());
        tv2 = (TextView)findViewById(R.id.japaneseSentenceTextView);
        Log.d("ERROR","\nError (tv2) => "+tv1.getError());
        tv3 = (TextView)findViewById(R.id.englishExpressionTextView);
        tv4 = (TextView)findViewById(R.id.descriptionLabelTextView);
        Log.d("ERROR","\nError (tv4) => "+tv1.getError());
        tv5 = (TextView)findViewById(R.id.descriptionTextView);
        tv6 = (TextView)findViewById(R.id.specificationLabelTextView);
        tv7 = (TextView)findViewById(R.id.specificationTextView);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        englishToJapaneseMenuContentDisplay_Data = getIntent().getExtras();
        if(englishToJapaneseMenuContentDisplay_Data == null) {
            return;
        }else{
            tv4.setText("Description (english)");
            tv6.setText("Specification (english)");
            String selectedMenuItem = englishToJapaneseMenuContentDisplay_Data.getString("selectedMenuItem");
            Toast.makeText(this,"selectedMenuItem : "+selectedMenuItem,Toast.LENGTH_SHORT).show();

            myDBHandler = new MyDBHandler(this,null,null,1);
            EnglishToJapaneseMenuContent_Model[] contentList;
            contentList=myDBHandler.getEnglishToJapaneseMenuContentDisplay(selectedMenuItem);

            if(contentList!=null){

                Toast.makeText(this,"contentList (Count) : "+contentList.length,Toast.LENGTH_SHORT).show();
                for(int i=0;i<contentList.length;i++){
                    Toast.makeText(this,"contentList (i) Japanese : "+contentList[i].getJapanese_sentence(),Toast.LENGTH_SHORT).show();
//                int i=0;
                    if(contentList[i].getActive()==1) {
                        tv1.setText(contentList[i].getEnglish_sentence());
                        tv2.setText(contentList[i].getJapanese_sentence());
                        tv3.setText(contentList[i].getEnglish_expression());
                        tv5.setText(contentList[i].getDescription());
                        tv7.setText(contentList[i].getSpecification());
                    }
                }

            }else{
                Toast.makeText(this,"NOTHING FOUND",Toast.LENGTH_SHORT).show();
            }
        }

    }

}
