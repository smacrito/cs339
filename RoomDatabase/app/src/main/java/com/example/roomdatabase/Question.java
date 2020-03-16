package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//entity is a table in room.
@Entity(tableName = "Questions") // set primary key to relate to primary key of answers in different table
public class Question {

    // every class must have 1 primary key
    @PrimaryKey
    private int questionID;

    // custom column name
    @ColumnInfo(name="Question")// remove later to only have Question, then make answers a separate table related by questionID
    private String question;
    @ColumnInfo(name="answer1")
    private String answer1;

//getter and setter methods for variables
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
}