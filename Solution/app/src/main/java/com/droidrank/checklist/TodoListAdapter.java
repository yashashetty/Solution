package com.droidrank.checklist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.*;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mobilityiMac on 09/04/18.
 */

public class TodoListAdapter extends BaseAdapter{
    private ArrayList<String>mArrayList;
    private LayoutInflater minflater;

    public TodoListAdapter(Context ctx , ArrayList<String>list) {
        mArrayList = list;
        minflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(mArrayList!= null)
         return mArrayList.size();

        return  0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void setList(ArrayList<String> list){
        mArrayList = list;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = minflater.inflate(R.layout.check_list_item,null);
            holder.itemName = (TextView)view.findViewById(R.id.tv_item_name);
            holder.btncheck =(Button)view.findViewById(R.id.bt_item_delete);
            view.setTag(holder);
        }else{
            holder =(ViewHolder)view.getTag();
        }

        if(mArrayList!= null){
            String itemname = mArrayList.get(i);
            holder.itemName.setText(itemname);
        }

        return  view;
    }

    private static class ViewHolder{

        protected TextView itemName;
        protected Button btncheck;
    }


}
