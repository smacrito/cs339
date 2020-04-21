package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClientOrHostFragment extends Fragment implements View.OnClickListener{

    private Button clientButton, hostButton;
    Startup startup = new Startup();


    public ClientOrHostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_or_host, container, false);
        //set buttons to button id to reference them
        clientButton = view.findViewById(R.id.select_client_button);
        hostButton = view.findViewById(R.id.select_host_button);


        //register listener for buttons
        clientButton.setOnClickListener(this);
        hostButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //Select client case
            case R.id.select_client_button:
                
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new answerQuestionFragment()).addToBackStack(null).commit();
                break;

            //Select host case
            case R.id.select_host_button:
                //Start server
                try{
                    startup.host();
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeFragment()).addToBackStack(null).commit();
                    break;
                }
                catch(Exception E){
                    System.out.println("Start server error start");
                    System.out.println(E);
                    System.out.println("Start Server error stop");
                }
                //Start hostfragment(homefragment)




        }
    }
}
