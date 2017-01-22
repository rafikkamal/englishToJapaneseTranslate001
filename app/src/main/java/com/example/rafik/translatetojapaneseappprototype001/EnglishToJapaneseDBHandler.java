package com.example.rafik.translatetojapaneseappprototype001;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class EnglishToJapaneseDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=9;
    private static final String DATABASE_NAME="translateToJapanese001.db";

    //TranslateEnglishToJapanese DATABASE
    public static final String TE2J_TABLE="translateEnglishToJapanese";
    public static final String TE2J_COLUMN_ID="_id";
    public static final String TE2J_COLUMN_ENGLISH_SENTENCE="english_sentence";
    public static final String TE2J_COLUMN_VARIATION="has_variation";
    public static final String TE2J_COLUMN_ACTIVE="active";
    public static final String TE2J_COLUMN_CREATED_AT="created_at";
    public static final String TE2J_COLUMN_UPDATED_AT="updated_at";

    //TranslateEnglishToJapaneseList DATABASE
    public static final String TE2JL_TABLE="translateEnglishToJapaneseList";
    public static final String TE2JL_COLUMN_ID="_id";
    public static final String TE2JL_COLUMN_TE2J_ID="_te2j_id";
    public static final String TE2JL_COLUMN_ENGLISH_SENTENCE="english_sentence";
    public static final String TE2JL_COLUMN_JAPANESE_SENTENCE="japanese_sentence";
    public static final String TE2JL_COLUMN_ENGLISH_EXPRESSION="english_expression";
    public static final String TE2JL_COLUMN_DESCRIPTION="description";
    public static final String TE2JL_COLUMN_SPECIFICATION="specification";
    public static final String TE2JL_COLUMN_ACTIVE="active";
    public static final String TE2JL_COLUMN_CREATED_AT="created_at";
    public static final String TE2JL_COLUMN_UPDATED_AT="updated_at";

    
    public EnglishToJapaneseDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, null, factory, DATABASE_VERSION);
        //Log.d("@@@@[EnglishToJapanese]>","database created!!!!!!!!!!!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Log.d("DATABASE OPERATIONS","%%%%%%%%%%%%"+TE2JL_TABLE+" table created!!!!!!!!!!!!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String query_TE2J = "DROP TABLE IF EXISTS " + TE2J_TABLE;
//        db.execSQL(query_TE2J);
//        String query_TE2JL = "DROP TABLE IF EXISTS " + TE2JL_TABLE;
//        db.execSQL(query_TE2JL);
//        //Log.d("DATABASE OPERATIONS","table upgraded!!!!!!!!!!!!!!!!!");
//        onCreate(db);
    }

    /*
     Get (String)selectedMenuItem from (class)EnglishToJapaneseMenu
     and return all the (String)english_sentence
     as (ListView)MenuItems to be selected
     */
    public String[] getEnglishToJapaneseMenuContent(String selectedMenuItem){
        String query;

        SQLiteDatabase db = getWritableDatabase();
        query = "SELECT "+TE2J_COLUMN_ENGLISH_SENTENCE+" FROM "+TE2J_TABLE;

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        //Log.d("DATABASE OPERATIONS","Total Item for getEnglishToJapaneseMenuContent(): "+c.getCount());
        String[] arr=new String[c.getCount()];
        int i=0;

        if(c.getCount()>0) {
            arr[i]=c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE));
            while (!c.isLast()) {
                i++;
                c.moveToNext();//must
                //Log.d("DATABASE OPERATIONS", "##### ENGLISH SENTENCE : "+i+" : " + c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE)));
                arr[i]=c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE));
            }
        }
        db.close();
        return arr;
    }

    /*
    Insert new MenuContentItem in Database
     */
    public void addEnglishToJapaneseMenuContentItem(){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TE2J_COLUMN_ENGLISH_SENTENCE, "My name is Rafik Kamal.");
        values.put(TE2J_COLUMN_VARIATION, 1);
        values.put(TE2J_COLUMN_ACTIVE, 1);
        db.insert(TE2J_TABLE, null, values);

        ContentValues values1 = new ContentValues();
        values1.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am from Bangladesh.");
        values1.put(TE2J_COLUMN_VARIATION, 1);
        values1.put(TE2J_COLUMN_ACTIVE, 1);
        db.insert(TE2J_TABLE, null, values1);

        ContentValues values2= new ContentValues();
        values2.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am 25 years old.");
        values2.put(TE2J_COLUMN_VARIATION, 1);
        values2.put(TE2J_COLUMN_ACTIVE, 1);
        db.insert(TE2J_TABLE, null, values2);

        ContentValues values3= new ContentValues();
        values3.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am studying in Tokyo University.");
        values3.put(TE2J_COLUMN_VARIATION, 1);
        values3.put(TE2J_COLUMN_ACTIVE, 1);
        db.insert(TE2J_TABLE, null, values3);

        ContentValues values4= new ContentValues();
        values4.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I live near Minato-ku train station.");
        values4.put(TE2J_COLUMN_VARIATION, 1);
        values4.put(TE2J_COLUMN_ACTIVE, 1);
        db.insert(TE2J_TABLE, null, values4);

        Log.d("DATABASE OPERATIONS", "EnglishToJapaneseMenuContentItem() : \nnew items added!!!!!!!!!!!!!!!!!");

    }

    public void addEnglishToJapaneseMenuContentDisplayItem(){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TE2JL_COLUMN_TE2J_ID, 1);
        values.put(TE2JL_COLUMN_ENGLISH_SENTENCE, "My name is Rafik.");
        values.put(TE2JL_COLUMN_JAPANESE_SENTENCE, "watashi wa rafik desu.");
        values.put(TE2JL_COLUMN_ENGLISH_EXPRESSION, "watashi wa rafik desu.");
        values.put(TE2JL_COLUMN_DESCRIPTION, "My name is Rafik.This is the description.This is the description.This is the description.This is the description.This is the description.");
        values.put(TE2JL_COLUMN_SPECIFICATION, "My name is Rafik.This is the specification.This is the specification.This is the specification.This is the specification.This is the specification.");
        values.put(TE2JL_COLUMN_ACTIVE, 1);
        db.insert(TE2JL_TABLE, null, values);
        getEnglishToJapaneseMenuContentDisplay("My name is Rafik.");
        Log.d("DATABASE OPERATIONS", "EnglishToJapaneseMenuContentDisplayItem() : \nnew items added!!!!!!!!!!!!!!!!!");

    }

    /*
    get all content from
    table <translateEnglishToJapaneseList>
    for the input <selectedMenuItem>
    from class <EnglishToJapaneseMenuContentDisplay>

    return
    an array of type <EnglishToJapaneseMenuContent_Model>
     */
    //EnglishToJapaneseMenuContent_Model[]
    public EnglishToJapaneseMenuContent_Model[] getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem){

        EnglishToJapaneseMenuContent_Model[] contentList = null;
        EnglishToJapaneseMenuContent_Model content = null;
        SQLiteDatabase db = getWritableDatabase();

        ////String query_Get_TE2JL_Content = "SELECT * FROM "+TE2JL_TABLE+" WHERE "+TE2JL_COLUMN_TE2J_ID+"="+TE2J_column_id;
        //String query_Get_TE2JL_Content = "SELECT * FROM "+TE2JL_TABLE+" WHERE "+TE2JL_COLUMN_ENGLISH_SENTENCE+" LIKE '%"+selectedMenuItem+"%'";
        String query = "SELECT * FROM "+TE2JL_TABLE;
        //String query = "SELECT * FROM users";

        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay=>\nquery : "+query);
        Cursor c = db.rawQuery(query,null);
        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count(out) : "+c.getCount());
        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>column(count) : "+c.getColumnCount());
        c.moveToFirst();

        contentList=new EnglishToJapaneseMenuContent_Model[c.getCount()];
        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count(out) : "+c.getCount());
        int i=0;


        if(c.getCount()>0) {

//            content.set_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ID)));
//            content.setActive(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ACTIVE)));
//            content.set_translation_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_TE2J_ID)));
//            content.setEnglish_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_SENTENCE)));
//            content.setJapanese_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_JAPANESE_SENTENCE)));
//            content.setEnglish_expression(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_EXPRESSION)));
//            content.setDescription(c.getString(c.getColumnIndex(TE2JL_COLUMN_DESCRIPTION)));
//            content.setSpecification(c.getString(c.getColumnIndex(TE2JL_COLUMN_SPECIFICATION)));
//            contentList[i]=content;

            while (!c.isLast()) {

                content.set_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ID)));
                content.setActive(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ACTIVE)));
                content.set_translation_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_TE2J_ID)));
                content.setEnglish_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_SENTENCE)));
                content.setJapanese_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_JAPANESE_SENTENCE)));
                content.setEnglish_expression(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_EXPRESSION)));
                content.setDescription(c.getString(c.getColumnIndex(TE2JL_COLUMN_DESCRIPTION)));
                content.setSpecification(c.getString(c.getColumnIndex(TE2JL_COLUMN_SPECIFICATION)));

                c.moveToNext();//must
                contentList[i]=content;
                i++;
                Log.d("DATABASE OPERATIONS", "##### ENGLISH SENTENCE : "+i+" : " + content.getEnglish_sentence());
            }
        }else{
            Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count : nothing");
        }
        db.close();

        return contentList;

    }
}
