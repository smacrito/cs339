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
public class answerQuestionFragment extends Fragment {

    private EditText questionID,userAnswer;
    private Button submitButton;


    public answerQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_answer_question,container, false);

        //retrieve data from text boxes
        questionID = view.findViewById(R.id.questionID_textbox);
        userAnswer = view.findViewById(R.id.answer_textbox);

        submitButton.setOnClickListener(new View.OnClickListener(){
            //set data to variables
            @Override
            public void onClick(View view){
                int question_id = Integer.parseInt(questionID.getText().toString());
                String userInput = userAnswer.getText().toString();
                

                Toast.makeText(getActivity(),"Question added", Toast.LENGTH_SHORT);

                questionID.setText("");

            }
        });

        return view;
    }

}
