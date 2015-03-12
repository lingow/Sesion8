package com.lingoware.lingow.sesion8;

import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lingow on 11/03/15.
 */
public class User implements Parcelable {
    public String email;
    public String password;
    public int loggedin;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int isLoggedin() {
        return loggedin;
    }

    public User(){
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoggedin(int loggedin) {
        this.loggedin = loggedin;
    }

    public User(SharedPreferences prefs){
        email=prefs.getString("EMAIL", null);
        password=prefs.getString("PASSWORD",null);
        loggedin=prefs.getInt("LOGGED", -1);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeInt(loggedin);
    }

    public User(String email, String password, int loggedin) {
        this.email = email;
        this.password = password;
        this.loggedin = loggedin;
    }

    public User(Parcel in){
        this.email = in.readString();
        this.password = in.readString();
        this.loggedin = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            // using parcelable constructor
            return new User(source);
        }
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void putToEditor(SharedPreferences.Editor ed) {
        ed.putString("EMAIL",email);
        ed.putString("PASSWORD",password);
        ed.putInt("LOGGED", loggedin);
    }

    public static void deleteFromPreferences(SharedPreferences.Editor ed) {
        ed.remove("EMAIL");
        ed.remove("PASSWORD");
        ed.remove("LOGGED");
    }
}
