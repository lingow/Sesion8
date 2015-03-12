package com.lingoware.lingow.sesion8;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ActivityMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User usr = getIntent().getParcelableExtra("USER");
        ((TextView)findViewById(R.id.txtEmail)).setText(usr.email);
        ((TextView)findViewById(R.id.txtPassword)).setText(usr.password);
        ((TextView)findViewById(R.id.txtLoggedIn)).setText("" + usr.loggedin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
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
            Intent i = new Intent(this,ActivityPreferences.class);
            startActivity(i);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            SharedPreferences prefs = getSharedPreferences("com.lingoware.lingow.sesion8.USER", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = prefs.edit();
            User.deleteFromPreferences(ed);
            ed.commit();
            Intent i = new Intent(this,ActivityLogin.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
