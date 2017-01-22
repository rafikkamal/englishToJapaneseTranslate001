package com.example.rafik.translatetojapaneseappprototype001;

/**
 * Created by Rafik on 1/14/2017.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private int _id,_active,_admin;
    private String _name,_email,_password;
    private String _created_at,_updated_at;

    public User(){}

    public User(String name, String password){
        this._name=name;
        this._password=password;
    }

    public User(String name, String email, String password){
        this._name=name;
        this._email=email;
        this._password=password;
        this._active=1;
        this._admin=0;
        this._created_at = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public int get_id() {
        return _id;
    }

    public int get_active() {
        return _active;
    }

    public int get_admin() {
        return _admin;
    }

    public String get_name() {
        return _name;
    }

    public String get_email() {
        return _email;
    }

    public String get_password() {
        return _password;
    }

    public String get_created_at() {
        return _created_at;
    }

    public String get_updated_at() {
        return _updated_at;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_active(int _active) {
        this._active = _active;
    }

    public void set_admin(int _admin) {
        this._admin = _admin;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_created_at(String _created_at) {
        this._created_at = _created_at;
    }

    public void set_updated_at(String _updated_at) {
        this._updated_at = _updated_at;
    }


    /***********/
    /*
    Check if User is registered
     */
    public void isUserRegistered(String name, String password){
        UserRegistration ur = new UserRegistration();
    }


}
