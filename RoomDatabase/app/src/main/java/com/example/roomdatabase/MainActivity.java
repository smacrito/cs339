package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
//TODO: add functions to buttons and adjust layout to make them lower
public class MainActivity extends AppCompatActivity {
    //create frag manager object
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adding instance of fragmanager
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            //adds fragment to main activity
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
    }
}
