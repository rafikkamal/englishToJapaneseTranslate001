package com.example.rafik.translatetojapaneseappprototype001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegisterValidation extends AppCompatActivity {

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register_validation);
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

    public void userValidationRegistrationButton(View view){

        EditText registerUserName = (EditText)findViewById(R.id.registerUserName);
        EditText registerUserEmail = (EditText)findViewById(R.id.registerUserEmail);
        EditText registerUserPassword = (EditText)findViewById(R.id.registerUserPassword);
        EditText registerUserPasswordConfirm = (EditText)findViewById(R.id.registerUserPasswordConfirm);

        String user_name = registerUserName.getText().toString();
        String user_email = registerUserEmail.getText().toString();
        String user_password = registerUserPassword.getText().toString();
        String user_password_confirm = registerUserPasswordConfirm.getText().toString();

        dbHandler = new MyDBHandler(this,null,null,1);

        if(user_name.length()>0){
            if(user_email.length()>0){
                if(user_password.length()>=3){
                    if(user_password.equals(user_password_confirm)){

                        if(dbHandler.registerNewUser(user_name,user_email,user_password)){
                            Toast.makeText(this,"You Have Successfully Registered",Toast.LENGTH_SHORT).show();
                            Intent mainIndex_Intent = new Intent(this,MainIndex.class);
                            startActivity(mainIndex_Intent);
                            registerUserName.setText("");
                            registerUserEmail.setText("");
                            registerUserPassword.setText("");
                            registerUserPasswordConfirm.setText("");
                        }else{
                            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(this,"Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"Enter a password",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"Enter a email",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Enter a username",Toast.LENGTH_SHORT).show();
        }


    }

}
