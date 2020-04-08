package com.example.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartServerFragment extends Fragment {

    public StartServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_question,container, false);

        //retrieve data from text boxes
        questionID = view.findViewById(R.id.questionID_textbox);
        questionInput = view.findViewById(R.id.question_textbox);
        answer1 = view.findViewById(R.id.answer1_textbox);
        answer2 = view.findViewById(R.id.answer2_textbox);
        correctAnswer = view.findViewById(R.id.correct_answer_textbox);
        submitButton = view.findViewById(R.id.submit_question_button);

        submitButton.setOnClickListener(new View.OnClickListener(){
            //set data to variables
            @Override
            public void onClick(View view){
                int question_id = Integer.parseInt(questionID.getText().toString());
                String userQuestion = questionInput.getText().toString();
                String userAnswer1 = answer1.getText().toString();
                String userAnswer2 = answer2.getText().toString();
                String userCorrectAnswer = correctAnswer.getText().toString();

                //create object of questionInput database class
                Question question = new Question();

                question.setQuestionID(question_id);
                question.setQuestion(userQuestion);
                question.setAnswer1(userAnswer1);
                question.setAnswer2(userAnswer2);
                question.setCorrectAnswer(userCorrectAnswer);

                MainActivity.QuestionDB.dao().addQuestion(question);
                Toast.makeText(getActivity(),"Question added", Toast.LENGTH_SHORT);

                questionID.setText("");
                questionInput.setText("");
                answer1.setText("");
                answer2.setText("");
                correctAnswer.setText("");


            }
        });

        return view;
    }
}
