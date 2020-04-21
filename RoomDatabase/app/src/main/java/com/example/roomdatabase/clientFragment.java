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
public class clientFragment extends Fragment implements View.OnClickListener{

    private Button answerQuestionButton, viewQuestionButton;


    public clientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //set buttons to button id to reference them
        answerQuestionButton = view.findViewById(R.id.answer_question_button);
        viewQuestionButton = view.findViewById(R.id.view_question_button);


        //register listener for buttons
        answerQuestionButton.setOnClickListener(this);
        viewQuestionButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //ADD QUESTION CASE
            case R.id.answer_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new answerQuestionFragment()).addToBackStack(null).commit();
                break;
            //VIEW QUESTION CASE
            case R.id.view_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadQuestionFragment()).addToBackStack(null).commit();
                break;


        }
    }
}