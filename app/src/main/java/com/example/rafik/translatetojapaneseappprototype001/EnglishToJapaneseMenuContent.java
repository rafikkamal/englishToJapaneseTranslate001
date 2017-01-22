package com.example.rafik.translatetojapaneseappprototype001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EnglishToJapaneseMenuContent extends AppCompatActivity {

    public String[] englishToJapaneseMenuContent_list;
    Bundle englishToJapaneseMenuContent_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_to_japanese_menu_content);
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

        //englishToJapaneseMenuContent_list=englishToJapaneseMenuContent_Data.getSerializable("englishToJapaneseMenuContent_Array");
        displayEnglishToJapaneseMenu();


    }

    public void displayEnglishToJapaneseMenu() {
        englishToJapaneseMenuContent_Data = getIntent().getExtras();
        if(englishToJapaneseMenuContent_Data == null) {
            return;
        }else{
            englishToJapaneseMenuContent_list=englishToJapaneseMenuContent_Data.getStringArray("englishToJapaneseMenuContent_Array");
            ListAdapter listAdapter = new CustomAdapter(this,englishToJapaneseMenuContent_list);
            ListView listView = (ListView) findViewById(R.id.englishToJapaneseMenuContentListView);
            listView.setAdapter(listAdapter);
            final Context context = this;
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedMenuItem = String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(context,selectedMenuItem,Toast.LENGTH_SHORT).show();

                    //EnglishToJapaneseDBHandler englishToJapaneseDBHandler = new EnglishToJapaneseDBHandler(context,null,null,1);

//                    String[] arr=englishToJapaneseDBHandler.getEnglishToJapaneseMenuContent(selectedMenuItem);
                    Intent englishToJapaneseMenuContentDisplay_Intent = new Intent(context,EnglishToJapaneseMenuContentDisplay.class);
//                    englishToJapaneseMenuContent_Intent.putExtra("englishToJapaneseMenuContent_Array",arr);
                    englishToJapaneseMenuContentDisplay_Intent.putExtra("selectedMenuItem",selectedMenuItem);
                    startActivity(englishToJapaneseMenuContentDisplay_Intent);
                }
            });
        }
    }

}
