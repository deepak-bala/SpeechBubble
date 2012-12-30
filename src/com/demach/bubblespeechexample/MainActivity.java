package com.demach.bubblespeechexample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends ListActivity 
{
    private List<String>  list = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    
    {
        list.add("Hello");
        list.add("Watcha doin ?");
        list.add("Aww nothing much. Just typing this really long message to show you how a 9 patch image can stretch.");
        list.add("Cool");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button findViewById =(Button) findViewById(R.id.talk_bt);
        findViewById.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText inputBox = (EditText) MainActivity.this.findViewById(R.id.input_text);
                String input = inputBox.getText().toString();
                adapter.add(input);
                runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
        ListView listView = getListView();
        
        adapter = new CustomArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
