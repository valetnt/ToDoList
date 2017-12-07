package com.example.android.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.todolist.CatalogActivity.toDoList;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Task> {

    /*
     * Constructor
     */
    public CustomAdapter(@NonNull Context context, @NonNull List<Task> objects) {
        /*
         * Superclass constructor is invoked with LayoutResId=0 because we are going to
         * inflate a customized list item layout from file
         */
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // If a view is already being used, recycle it. Else, inflate it from a layout file.
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,
                    false);
        }

        Task currentTask = getItem(position);
        TextView taskTitle = (TextView) view.findViewById(R.id.task_title);
        taskTitle.setText(currentTask.getTaskTitle());
        boolean checkedStatus = currentTask.getTaskCheckedStatus();
        final Button buttonCheck = (Button) view.findViewById(R.id.check_button);
        final ImageView checkedOk = (ImageView) view.findViewById(R.id.checked_ok);
        if (!checkedStatus) {
            buttonCheck.setVisibility(View.VISIBLE);
            checkedOk.setVisibility(View.GONE);
        } else {
            buttonCheck.setVisibility(View.GONE);
            checkedOk.setVisibility(View.VISIBLE);
        }
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCheck.setVisibility(View.GONE);
                checkedOk.setVisibility(View.VISIBLE);
                toDoList.get(position).setTaskCheckedStatus(true);
            }
        });

        return view;
    }
}
