package com.droidrank.checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewItem extends AppCompatActivity {

    // To take the user input for the new item
    EditText itemName;
    // To add the new item to the list
    Button addItem;
    // To cancel this task
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        itemName = (EditText) findViewById(R.id.et_item_name);
        cancel = (Button) findViewById(R.id.bt_cancel);
        addItem = (Button) findViewById(R.id.bt_ok);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(itemName.getText().toString().equals("")){
                    itemName.setError(getResources().getString(R.string.item_name_required_message));
                }else{
                    String item=itemName.getText().toString();
                    Intent intent=new Intent();
                    intent.putExtra(Constant.ADD_ITEM,item);
                    setResult(Constant.ADD_NEW_REQUESTCODE,intent);
                    finish();
                }

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Do nothing and close this activity
                 */
                setResult(RESULT_CANCELED);

                finish();
            }
        });
    }
}
