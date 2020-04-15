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
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button addQuestionButton, viewQuestionButton, startServerButton, sendDataButton, getDataButton;
    UDP_Server udp = new UDP_Server();
    UDP_Client udpClient = new UDP_Client();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //set buttons to button id to reference them
        addQuestionButton = view.findViewById(R.id.add_question_button);
        viewQuestionButton = view.findViewById(R.id.view_question_button);
        startServerButton = view.findViewById(R.id.start_server_button);
        sendDataButton = view.findViewById(R.id.send_data_button);
        getDataButton = view.findViewById(R.id.get_data_button);

        //register listener for buttons
        addQuestionButton.setOnClickListener(this);
        viewQuestionButton.setOnClickListener(this);
        startServerButton.setOnClickListener(this);
        sendDataButton.setOnClickListener(this);
        getDataButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //ADD QUESTION CASE
            case R.id.add_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddQuestionFragment()).addToBackStack(null).commit();
                break;
            //VIEW QUESTION CASE
            case R.id.view_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadQuestionFragment()).addToBackStack(null).commit();
                break;
            case R.id.start_server_button:
                //MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new StartServerFragment()).addToBackStack(null).commit();
                try{
                    udp.execute();
                    break;

                }
                catch(Exception E){
                    System.out.println("Start server error start");
                    System.out.println(E);
                    System.out.println("Start Server error stop");
                }
            case R.id.stop_server_button:
                try{
                    udp.stopServer();
                    break;
                }
                catch(Exception E){
                    System.out.println("Stop Server error start");
                    System.out.println(E);
                    System.out.println("Stop Server error stop");
                }
            case R.id.get_data_button:
                try{
                    System.out.println("get_data_button clicked");
                    udpClient.execute();
                    break;
                }
                catch(Exception E){
                    System.out.println(E);
                }
            case R.id.send_data_button:
                try{
                    System.out.println("send_data_button clicked");
                    udpClient.clientSend();
                    break;
                }
                catch(Exception E){
                    System.out.println(E);
                }



        }
    }
}
