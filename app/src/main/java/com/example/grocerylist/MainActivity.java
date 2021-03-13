package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> list;
    Button addItemButton;
    String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvItems = (RecyclerView) findViewById(R.id.rv_items);

        list = Item.createList(0, "");
        ItemsAdapter adapter = new ItemsAdapter(list);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            itemName = bundle.getString("data");
        }

        addItemButton = (Button) findViewById(R.id.add_button);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etv = sendButton();
                //adapter.addRow(etv);

                int curSize = adapter.getItemCount();

                ArrayList<Item> newList = Item.createList(1, etv);//itemName);

                list.addAll(newList);
                adapter.notifyItemRangeInserted(curSize, newList.size());
            }
        });
    }

    public String sendButton() {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String editTextValue = editText.getText().toString();

        return editTextValue;
        //adapter.addRow(editTextValue);
    }
}