package com.example.rafik.translatetojapaneseappprototype001;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=11;
    private static final String DATABASE_NAME="translateToJapanese001.db";
    //USERS DATABASE
    public static final String USERS_TABLE="users";
    public static final String USERS_COLUMN_ID="_id";
    public static final String USERS_COLUMN_NAME="name";
    public static final String USERS_COLUMN_EMAIL="email";
    public static final String USERS_COLUMN_PASSWORD="password";
    public static final String USERS_COLUMN_ACTIVE="active";
    public static final String USERS_COLUMN_ADMIN="admin";
    public static final String USERS_COLUMN_CREATED_AT="created_at";
    public static final String USERS_COLUMN_UPDATED_AT="updated_at";

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


    SQLiteDatabase db;

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        db = getWritableDatabase();
        if(db.getVersion()!=DATABASE_VERSION) {
            Log.d("DATABASE OPERATIONS", "database created!\nPath : " + context.getDatabasePath(DATABASE_NAME).toString());
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ USERS_TABLE +" ( " +
                USERS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                USERS_COLUMN_NAME  + " VARCHAR(255) NOT NULL ," +
                USERS_COLUMN_EMAIL  + " VARCHAR(255) NOT NULL ," +
                USERS_COLUMN_PASSWORD  + " VARCHAR(255) NOT NULL ," +
                USERS_COLUMN_ACTIVE  + " INTEGER DEFAULT 0 ," +
                USERS_COLUMN_ADMIN  + " INTEGER DEFAULT 1 ," +
                USERS_COLUMN_CREATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP ," +
                USERS_COLUMN_UPDATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                ");";
        db.execSQL(query);
        Log.d("DATABASE OPERATIONS",USERS_TABLE+ "table created!!!!!!!!!!!!");

        ContentValues values = new ContentValues();
        values.put(USERS_COLUMN_NAME, "admin");
        values.put(USERS_COLUMN_EMAIL, "admin.admin@gmail.com");
        values.put(USERS_COLUMN_PASSWORD, "admin");
        values.put(USERS_COLUMN_ADMIN, 1);
        values.put(USERS_COLUMN_ACTIVE, 1);
        db.insert(USERS_TABLE, null, values);
        Log.d("DATABASE OPERATIONS","admin created!!!!!!!!!!!!");

        String query_TE2J = "CREATE TABLE "+ TE2J_TABLE +" ( " +
                TE2J_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TE2J_COLUMN_ENGLISH_SENTENCE + " TEXT NOT NULL ," +
                TE2J_COLUMN_VARIATION + " INTEGER NOT NULL ," +
                TE2J_COLUMN_ACTIVE  + " INTEGER NOT NULL ," +
                TE2J_COLUMN_CREATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP ," +
                TE2J_COLUMN_UPDATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                ");";
        db.execSQL(query_TE2J);
        Log.d("DATABASE OPERATIONS",TE2J_TABLE+ "table created!!!!!!!!!!!!");

        addEnglishToJapaneseMenuContentItem(db);
        Log.d("DATABASE OPERATIONS",TE2J_TABLE+ " has values inserted!!!!!!!!!!!!");

        String query_TE2JL = "CREATE TABLE "+ TE2JL_TABLE +" ( " +
                TE2JL_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TE2JL_COLUMN_TE2J_ID + " INTEGER NOT NULL , " +
                TE2JL_COLUMN_ENGLISH_SENTENCE + " TEXT NOT NULL ," +
                TE2JL_COLUMN_JAPANESE_SENTENCE + " TEXT NOT NULL ," +
                TE2JL_COLUMN_ENGLISH_EXPRESSION + " TEXT NOT NULL ," +
                TE2JL_COLUMN_DESCRIPTION + " TEXT NOT NULL ," +
                TE2JL_COLUMN_SPECIFICATION + " TEXT NOT NULL ," +
                TE2JL_COLUMN_ACTIVE  + " INTEGER DEFAULT 1 ," +
                TE2JL_COLUMN_CREATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP ," +
                TE2JL_COLUMN_UPDATED_AT  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                //", " + TE2JL_COLUMN_TE2J_ID + " INTEGER FOREIGN KEY REFERENCES " +
                //TE2J_TABLE + "(" + TE2J_COLUMN_ID + ") " +
                ");";
        db.execSQL(query_TE2JL);
        Log.d("DATABASE OPERATIONS",TE2JL_TABLE+ "table created!!!!!!!!!!!!");

        addEnglishToJapaneseMenuContentDisplayItem(db);
        Log.d("DATABASE OPERATIONS",TE2JL_TABLE+ " has values inserted!!!!!!!!!!!!");

        //db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + USERS_TABLE;
        db.execSQL(query);
        Log.d("DATABASE OPERATIONS",USERS_TABLE+" table upgraded!!!!!!!!!!!!!!!!!");
        query = "DROP TABLE IF EXISTS " + TE2J_TABLE;
        db.execSQL(query);
        Log.d("DATABASE OPERATIONS",TE2JL_TABLE+" table upgraded!!!!!!!!!!!!!!!!!");
        query = "DROP TABLE IF EXISTS " + TE2JL_TABLE;
        db.execSQL(query);
        Log.d("DATABASE OPERATIONS",TE2JL_TABLE+" table upgraded!!!!!!!!!!!!!!!!!");
        onCreate(db);
    }

    /*
    Validate and Register new User in database
     */
    public boolean registerNewUser(String name,String email,String password) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM users WHERE name='" + name + "';";
        Cursor c = db.rawQuery(query, null);
        if (c.getCount() == 1) {
            return false;
        } else{
            ContentValues values = new ContentValues();
            values.put(USERS_COLUMN_NAME, name);
            values.put(USERS_COLUMN_EMAIL, email);
            values.put(USERS_COLUMN_PASSWORD, password);
            values.put(USERS_COLUMN_ADMIN, 0);
            values.put(USERS_COLUMN_ACTIVE, 1);
            db.insert(USERS_TABLE, null, values);
            Log.d("DATABASE OPERATIONS", "new user added!!!!!!!!!!!!!!!!!");
        }
        ////db.close();
        return true;
    }


    public User getUser(String name, String password){
        User user = null;
        SQLiteDatabase db = getWritableDatabase();
        //String query = "SELECT * FROM users;";
        //String query = "SELECT * FROM users WHERE name='"+name+"';";
        String query = "SELECT * FROM users WHERE name='"+name+"' AND password = '"+password+"';";
        //Log.d("DATABASE OPERATIONS","Query for Log In : "+query);
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        //Log.d("DATABASE OPERATIONS","Total Item : "+c.getCount());
        if(c.getCount()>0) {
            user = new User();
            //Log.d("DATABASE OPERATIONS", "##### USER NAME : " + c.getString(c.getColumnIndex(USERS_COLUMN_NAME)));
            user.set_id(c.getColumnIndex(USERS_COLUMN_ID));
            user.set_name(c.getString(c.getColumnIndex(USERS_COLUMN_NAME)));
            user.set_email(c.getString(c.getColumnIndex(USERS_COLUMN_EMAIL)));
            user.set_active(c.getInt(c.getColumnIndex(USERS_COLUMN_ACTIVE)));
            user.set_admin(c.getInt(c.getColumnIndex(USERS_COLUMN_ADMIN)));
            user.set_created_at(c.getString(c.getColumnIndex(USERS_COLUMN_CREATED_AT)));
        }
        ////db.close();
        return user;
    }














    /*
    Insert new MenuContentItem in Database
     */
    public void addEnglishToJapaneseMenuContentItem(SQLiteDatabase db1){
        //SQLiteDatabase db1 = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TE2J_COLUMN_ENGLISH_SENTENCE, "My name is Rafik Kamal.");
        values.put(TE2J_COLUMN_VARIATION, 1);
        values.put(TE2J_COLUMN_ACTIVE, 1);
        db1.insert(TE2J_TABLE, null, values);

        ContentValues values1 = new ContentValues();
        values1.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am from Bangladesh.");
        values1.put(TE2J_COLUMN_VARIATION, 1);
        values1.put(TE2J_COLUMN_ACTIVE, 1);
        db1.insert(TE2J_TABLE, null, values1);

        ContentValues values2= new ContentValues();
        values2.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am 25 years old.");
        values2.put(TE2J_COLUMN_VARIATION, 1);
        values2.put(TE2J_COLUMN_ACTIVE, 1);
        db1.insert(TE2J_TABLE, null, values2);

        ContentValues values3= new ContentValues();
        values3.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I am studying in Tokyo University.");
        values3.put(TE2J_COLUMN_VARIATION, 1);
        values3.put(TE2J_COLUMN_ACTIVE, 1);
        db1.insert(TE2J_TABLE, null, values3);

        ContentValues values4= new ContentValues();
        values4.put(TE2J_COLUMN_ENGLISH_SENTENCE, "I live near Minato-ku train station.");
        values4.put(TE2J_COLUMN_VARIATION, 1);
        values4.put(TE2J_COLUMN_ACTIVE, 1);
        db1.insert(TE2J_TABLE, null, values4);

        Log.d("DATABASE OPERATIONS", "EnglishToJapaneseMenuContentItem() : \nnew items added!!!!!!!!!!!!!!!!!");

    }

    public void addEnglishToJapaneseMenuContentDisplayItem(SQLiteDatabase db2){

        //SQLiteDatabase db2 = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TE2JL_COLUMN_TE2J_ID, 1);
        values.put(TE2JL_COLUMN_ENGLISH_SENTENCE, "My name is Rafik Kamal.");
        values.put(TE2JL_COLUMN_JAPANESE_SENTENCE, "私の名前はrafik kamalです");
        values.put(TE2JL_COLUMN_ENGLISH_EXPRESSION, "watashi wa rafik kamal desu.");
        values.put(TE2JL_COLUMN_DESCRIPTION, "My name is Rafik.This is the description.This is the description.This is the description.This is the description.This is the description.");
        values.put(TE2JL_COLUMN_SPECIFICATION, "My name is Rafik.This is the specification.This is the specification.This is the specification.This is the specification.This is the specification.");
        values.put(TE2JL_COLUMN_ACTIVE, 1);
        db2.insert(TE2JL_TABLE, null, values);
        //getEnglishToJapaneseMenuContentDisplay("My name is Rafik.");
        Log.d("DATABASE OPERATIONS", "EnglishToJapaneseMenuContentDisplayItem() : \nnew items added!!!!!!!!!!!!!!!!!");

    }


    /*
     Get (String)selectedMenuItem from (class)EnglishToJapaneseMenu
     and return all the (String)english_sentence
     as (ListView)MenuItems to be selected
     */
    public String[] getEnglishToJapaneseMenuContent(String selectedMenuItem){
        String query;
        ////////SQLiteDatabase db = getWritableDatabase();
        query = "SELECT "+TE2J_COLUMN_ENGLISH_SENTENCE+" FROM "+TE2J_TABLE;

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        Log.d("DATABASE OPERATIONS","Total Item for getEnglishToJapaneseMenuContent(): "+c.getCount());
        String[] arr=null;

        if(c.getCount()>0) {
            int i=0;
            arr=new String[c.getCount()];
            arr[i]=c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE));
            while (!c.isLast()) {
                c.moveToNext();//must
                i++;
                Log.d("DATABASE OPERATIONS", "##### ENGLISH SENTENCE : "+i+" : \n" + c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE)));
                arr[i]=c.getString(c.getColumnIndex(TE2J_COLUMN_ENGLISH_SENTENCE));
            }
        }
        ////db.close();
        return arr;
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
        EnglishToJapaneseMenuContent_Model content = new EnglishToJapaneseMenuContent_Model();
        /////////////SQLiteDatabase db = getWritableDatabase();

        ////String query_Get_TE2JL_Content = "SELECT * FROM "+TE2JL_TABLE+" WHERE "+TE2JL_COLUMN_TE2J_ID+"="+TE2J_column_id;
        //String query_Get_TE2JL_Content = "SELECT * FROM "+TE2JL_TABLE+" WHERE "+TE2JL_COLUMN_ENGLISH_SENTENCE+" LIKE '%"+selectedMenuItem+"%'";
        String query = "SELECT * FROM "+TE2JL_TABLE;
        //String query = "SELECT * FROM users";

        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay=>\nquery : "+query);
        Cursor c = db.rawQuery(query,null);
        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count(out) : "+c.getCount());
        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>column(count) : "+c.getColumnCount());
        c.moveToFirst();

        Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count(out) : "+c.getCount());


        if(c.getCount()>0) {
            int i=0;
            contentList=new EnglishToJapaneseMenuContent_Model[c.getCount()];
            content.set_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ID)));
            content.setActive(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ACTIVE)));
            content.set_translation_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_TE2J_ID)));
            content.setEnglish_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_SENTENCE)));
            content.setJapanese_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_JAPANESE_SENTENCE)));
            content.setEnglish_expression(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_EXPRESSION)));
            content.setDescription(c.getString(c.getColumnIndex(TE2JL_COLUMN_DESCRIPTION)));
            content.setSpecification(c.getString(c.getColumnIndex(TE2JL_COLUMN_SPECIFICATION)));
            contentList[i]=content;

            Log.d("DATABASE OPERATIONS", "##### ENGLISH SENTENCE : "+i+" : " + content.getEnglish_sentence());
            while (!c.isLast()) {

                c.moveToNext();//must

                content.set_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ID)));
                content.setActive(c.getInt(c.getColumnIndex(TE2JL_COLUMN_ACTIVE)));
                content.set_translation_id(c.getInt(c.getColumnIndex(TE2JL_COLUMN_TE2J_ID)));
                content.setEnglish_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_SENTENCE)));
                content.setJapanese_sentence(c.getString(c.getColumnIndex(TE2JL_COLUMN_JAPANESE_SENTENCE)));
                content.setEnglish_expression(c.getString(c.getColumnIndex(TE2JL_COLUMN_ENGLISH_EXPRESSION)));
                content.setDescription(c.getString(c.getColumnIndex(TE2JL_COLUMN_DESCRIPTION)));
                content.setSpecification(c.getString(c.getColumnIndex(TE2JL_COLUMN_SPECIFICATION)));

                contentList[i]=content;
                i++;
                Log.d("DATABASE OPERATIONS", "##### ENGLISH SENTENCE : "+i+" : " + content.getEnglish_sentence());
            }
        }else{
            Log.d("TE2J & TE2JL OPERATION","getEnglishToJapaneseMenuContentDisplay(String selectedMenuItem)=>count : nothing");
        }
        //db.close();

        return contentList;

    }














}
