package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;




public class clientReadQuestionFragment extends Fragment {

    private TextView TxtInfo;

    public clientReadQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_read_question, container, false);
        TxtInfo = view.findViewById(R.id.questionContent);
        //create list of question objects
        List<Question> questions = MainActivity.QuestionDB.dao().getQuestion();

        String info = "";

        for(Question question: questions){
            int id = question.getQuestionID();
            String userQuestion = question.getQuestion();
            String userAnswer1 = question.getAnswer1();
            String userAnswer2 = question.getAnswer2();
            info = info + "\n\nid: " + id + "\nQuestion: " + userQuestion + "\n" + "Answer1: " + userAnswer1 + "\n Answer2: " + userAnswer2;
        }

        TxtInfo.setText(info);

        return view;
    }

}
