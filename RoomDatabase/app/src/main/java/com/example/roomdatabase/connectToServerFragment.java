package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class connectToServerFragment extends Fragment {

    private EditText inetAddress,port;
    private Button submitButton;
    Startup startup = new Startup();

    public connectToServerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_connect_to_server,container, false);

        //retrieve data from text boxes
        inetAddress = view.findViewById(R.id.inet_textbox);
        port = view.findViewById(R.id.port_textbox);

        submitButton.setOnClickListener(new View.OnClickListener(){
            //set data to variables
            @Override
            public void onClick(View view){
                String userInetAddress = inetAddress.getText().toString();
                int userPort = Integer.parseInt(port.getText().toString());

                try{
                    startup.joinMeeting(userInetAddress,userPort);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new clientAnswerOrViewFragment()).addToBackStack(null).commit();

                }
                catch(Exception E){
                    System.out.println(E);
                }


                Toast.makeText(getActivity(),"Server added", Toast.LENGTH_SHORT);

                inetAddress.setText("");
                port.setText("");

            }
        });

        return view;
    }

}
