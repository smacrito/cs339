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
public class clientAnswerOrViewFragment extends Fragment implements View.OnClickListener{

    private Button viewButton, answerButton;


    public clientAnswerOrViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_answer_or_view, container, false);
        //set buttons to button id to reference them
        viewButton = view.findViewById(R.id.view_question_button);
        answerButton = view.findViewById(R.id.answer_question_button);


        //register listener for buttons
        viewButton.setOnClickListener(this);
        answerButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //Select client case
            case R.id.view_question_button:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new clientReadQuestionFragment()).addToBackStack(null).commit();
                break;

            //Select host case
            case R.id.answer_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new answerQuestionFragment()).addToBackStack(null).commit();
                //Start hostfragment(homefragment)




        }
    }
}
