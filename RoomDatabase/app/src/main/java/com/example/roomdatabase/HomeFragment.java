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

    private Button addQuestionButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addQuestionButton = view.findViewById(R.id.add_question_button);
        //register listener for button
        addQuestionButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_question_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddQuestionFragment()).addToBackStack(null).commit();
                break;


        }
    }
}
