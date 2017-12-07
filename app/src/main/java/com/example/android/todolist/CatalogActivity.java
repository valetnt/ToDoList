package com.example.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity {

    public static ArrayList<Task> toDoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ListView listView = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this, toDoList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.add) {
            Intent openEditor = new Intent(this, EditorActivity.class);
            startActivity(openEditor);
            return true;
        }
        return false;
    }
}
