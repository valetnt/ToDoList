package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.todolist.CatalogActivity.toDoList;

public class EditorActivity extends AppCompatActivity {

    private TextView mNewTask;

    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cancel || v.getId() == R.id.add) {
                if (v.getId() == R.id.add) {
                    toDoList.add(new Task(mNewTask.getText().toString()));
                }
                Intent backToCatalog = new Intent(v.getContext(), CatalogActivity.class);
                startActivity(backToCatalog);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        mNewTask = (TextView) findViewById(R.id.new_task);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button add = (Button) findViewById(R.id.add);
        cancel.setOnClickListener(mListener);
        add.setOnClickListener(mListener);
    }

}
