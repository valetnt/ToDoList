package com.example.android.todolist;

public class Task {

    private String mTaskTitle;
    private boolean mTaskIsChecked;

    /*
     * Constructor
     */
    public Task(String title) {
        mTaskTitle = title;
        mTaskIsChecked = false;
    }

    /*
     * Setters
     */
    public void setTaskCheckedStatus(boolean checkedStatus) {
        mTaskIsChecked = checkedStatus;
    }

    /*
     * Getters
     */
    public String getTaskTitle() {
        return mTaskTitle;
    }

    public boolean getTaskCheckedStatus() {
        return mTaskIsChecked;
    }
}

