package com.ahmedkhaled.cpuz.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ahmedkhaled.cpuz.R;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 6/19/2017.
 */

public class ListAdapter extends BaseAdapter {

    ArrayList<Data> dataArrayList=new ArrayList<>();
    Context context;

    public ListAdapter(Context context, ArrayList<Data> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataArrayList.get(position).name;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(context);

        View view=  inflater.inflate(R.layout.custom_list,null);

        TextView name= (TextView) view.findViewById(R.id.name);
        TextView value= (TextView) view.findViewById(R.id.value);

        name.setText(dataArrayList.get(position).name);
        value.setText(dataArrayList.get(position).value);

        return view;
    }
}
