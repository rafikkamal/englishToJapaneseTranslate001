package com.example.rafik.translatetojapaneseappprototype001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    //EnglishToJapaneseDBHandler englishToJapaneseDBHandler;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        dbHandler = new MyDBHandler(this,null,null,1);
        //englishToJapaneseDBHandler = new EnglishToJapaneseDBHandler(this,null,null,1);

    }

    /*
    Log In User
     */
    public void logUser(View view){
        EditText userNameEditText = (EditText)findViewById(R.id.logUserNameEditText);
        EditText userPasswordEditText = (EditText)findViewById(R.id.logUserPasswordEditText);

        String user_name = userNameEditText.getText().toString();
        String user_password = userPasswordEditText.getText().toString();

        if(user_name.length()>0 && user_password.length()>0){

            dbHandler = new MyDBHandler(this,null,null,1);
            User user = dbHandler.getUser(user_name,user_password);

            if(user!=null){
                Toast.makeText(this,"Logged In As "+user.get_name()+" & Admin : "+user.get_admin(),Toast.LENGTH_SHORT).show();
                if(user.get_admin()==1){
                    Intent adminMainIndex_Intent = new Intent(this, AdminMainIndex.class);
                    startActivity(adminMainIndex_Intent);
                }else if(user.get_active()==1){
                    Intent mainIndex_Intent = new Intent(this, MainIndex.class);
                    startActivity(mainIndex_Intent);
                }
                userNameEditText.setText("");
                userPasswordEditText.setText("");
            }else{
                Toast.makeText(this,"Invalid User",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Enter Username/Password First",Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Register User
     */
    public void registerUser(View view){
        Toast.makeText(this,"Register",Toast.LENGTH_SHORT).show();
        Intent userRegisterValidatoin_Intent = new Intent(this,UserRegisterValidation.class);
        userRegisterValidatoin_Intent.putExtra("name","name");
        startActivity(userRegisterValidatoin_Intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
