package com.example.roomdatabase;
import androidx.room.Database;
import androidx.room.RoomDatabase;

//represents the database
//requires two properties: question table, and version
@Database(entities={Question.class},version=1)
public abstract class QuestionDB extends RoomDatabase{

    public abstract DataAccessObject dao();
}
