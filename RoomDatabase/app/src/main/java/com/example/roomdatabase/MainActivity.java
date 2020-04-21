package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
//TODO: add functions to buttons and adjust layout to make them lower
public class MainActivity extends AppCompatActivity {

    //create frag manager object
    public static FragmentManager fragmentManager;
    //database variables
    public static QuestionDB QuestionDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create instance of fragmanager
        fragmentManager = getSupportFragmentManager();

        //create instance of database   context shows android we are referencing something outside of our scope for use in another context
        QuestionDB = Room.databaseBuilder(getApplicationContext(),QuestionDB.class,"questionDB").allowMainThreadQueries().build();
                                                                                                    //TODO: change allowMainThreadQueries() to a library that allows a seperate thread to open.
                                                                                                    // bad practice to have this on main thread
        // add first fragment to main activity
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            //adds fragment to container            specify container           specify fragment
            fragmentManager.beginTransaction().add(R.id.fragment_container,new ClientOrHostFragment()).commit();
        }
    }
}
