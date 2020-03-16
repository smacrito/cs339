package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//entity is a table in room.
@Entity(tableName = "Questions") // set primary key to relate to primary key of answers in different table
public class addQuestion {

    // every class must have 1 primary key
    @PrimaryKey
    private int questionID;

    // custom column name
    @ColumnInfo(name="Question")// remove later to only have question, then make answers a separate table related by questionID
    private String question;
    @ColumnInfo(name="answer1")
    private String answer1;
    @ColumnInfo(name="answer2")
    private String answer2;
    @ColumnInfo(name="answer3")
    private String answer3;
    @ColumnInfo(name="answer4")
    private String answer4;
    @ColumnInfo(name="correct_answer")
    private String correctAnswer;


}
