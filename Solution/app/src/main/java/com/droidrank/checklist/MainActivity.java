package com.droidrank.checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // To display the items in the list
    ListView listView;
    // To add a new item
    Button addNew;
    private TodoListAdapter itemsAdapter;
    private ArrayList<String>items ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        itemsAdapter = new TodoListAdapter(this,items);

        ArrayList<String> default_items = new ArrayList<String>(Arrays.asList(getResources().getStringArray( R.array.default_items)));

       items = new ArrayList<>();
        items.addAll(default_items);

        addNew = (Button) findViewById(R.id.bt_add_new_item);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Add a new item to the checklist
                 */
                Intent intent = new Intent(MainActivity.this, AddNewItem.class);


                startActivityForResult(intent,Constant.ADD_NEW_REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED){
            return;
        }

        switch (requestCode){

        case Constant.ADD_NEW_REQUESTCODE:


            String item=data.getStringExtra(Constant.ADD_ITEM);
            addItem(item);
            refreshList();

            break;


        }


    }


    /** Adds Item to list
     **/
    private void addItem(String message){
        if(items == null){
            items = new ArrayList<String>();
        }
        items.add(message);

    }

   /** Refresh the list item */
    private void refreshList(){

        itemsAdapter.setList(items);
        listView.setAdapter(itemsAdapter);
        itemsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Refresh the checklist
        refreshList();
    }




}
