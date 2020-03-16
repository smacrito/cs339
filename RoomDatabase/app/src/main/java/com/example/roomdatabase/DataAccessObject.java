package com.example.roomdatabase;
//dataaccessobject
import androidx.room.Dao;
import androidx.room.Insert;


@Dao
public interface DataAccessObject {

    @Insert
    public void addQuestion(Question question);
}
