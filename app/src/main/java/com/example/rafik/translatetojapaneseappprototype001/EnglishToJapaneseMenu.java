package com.example.rafik.translatetojapaneseappprototype001;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class EnglishToJapaneseMenu extends AppCompatActivity {

    //EnglishToJapaneseDBHandler englishToJapaneseDBHandler;
    MyDBHandler myDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_to_japanese_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView englishToJapaneseTextView = (TextView)findViewById(R.id.englishToJapaneseTextView);
        englishToJapaneseTextView.setText("English to Japanese");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        displayEnglishToJapaneseMenu();
    }

    public void displayEnglishToJapaneseMenu(){
        String[] list = {"Introduction","Greeting","Numbers","Date and Time","Market","Direction","Inquiry","Travelling","Introduction","Greeting","Numbers","Date and Time","Market","Direction","Inquiry","Travelling"};
        //ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ListAdapter listAdapter = new CustomAdapter(this,list);
        ListView listView = (ListView)findViewById(R.id.englishToJapaneseMenuListView);
        listView.setAdapter(listAdapter);
        final Context context = this;
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedMenuItem = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(context,selectedMenuItem,Toast.LENGTH_SHORT).show();

                        //englishToJapaneseDBHandler = new EnglishToJapaneseDBHandler(context,null,null,1);

                        /*/String[] arr=englishToJapaneseDBHandler.getEnglishToJapaneseMenuContent(selectedMenuItem);*/

                        myDBHandler = new MyDBHandler(context,null,null,1);
                        myDBHandler.getEnglishToJapaneseMenuContent(selectedMenuItem);

                        String[] arr=myDBHandler.getEnglishToJapaneseMenuContent(selectedMenuItem);
                        if(arr!=null) {
                        Intent englishToJapaneseMenuContent_Intent = new Intent(context,EnglishToJapaneseMenuContent.class);
                        englishToJapaneseMenuContent_Intent.putExtra("englishToJapaneseMenuContent_Array",arr);
                        startActivity(englishToJapaneseMenuContent_Intent);
                        }else{
                            Toast.makeText(context,"Null",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

}
