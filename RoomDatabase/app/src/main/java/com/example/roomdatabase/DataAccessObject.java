package com.example.roomdatabase;
//dataaccessobject
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataAccessObject {

    @Insert
    void addQuestion(Question question);

    //query against db
    //return all from questionstable
    @Query("select * from QuestionsTable")
    List<Question> getQuestion();

}
