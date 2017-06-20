package com.ahmedkhaled.cpuz.pager;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ahmedkhaled.cpuz.Data.Battery;
import com.ahmedkhaled.cpuz.Data.OnReceiveListener;
import com.ahmedkhaled.cpuz.Model.Data;
import com.ahmedkhaled.cpuz.Model.ListAdapter;
import com.ahmedkhaled.cpuz.R;
import com.ahmedkhaled.cpuz.Data.Specefication;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 6/17/2017.
 */

public class MyFragment extends Fragment  implements OnReceiveListener{
    int position;
    ListView listView;
    Specefication specefication=new Specefication();
    ArrayList<Data> batteryInfo;
    Battery battery;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        battery=new Battery(this);
        context.registerReceiver( battery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        batteryInfo=new ArrayList<>();
       View view=inflater.inflate(R.layout.my_fragment,container,false);
        listView= (ListView) view.findViewById(R.id.list);

        Bundle bundle=getArguments();
        position=bundle.getInt("position");

        if (position==0){
            ListAdapter adapter =new ListAdapter(getContext(),specefication.getDeviceSpecification());
            listView.setAdapter(adapter);
        }

        if (position==2){
            ListAdapter adapter =new ListAdapter(getContext(),specefication.getSystemeSpecification());
            listView.setAdapter(adapter);
        }



        return view;
    }


    @Override
    public void onDataReceived(int level,String health,String status,String connection,int voltage,int temp) {
        Bundle bundle=getArguments();
        position=bundle.getInt("position");
        if (position==1){
            batteryInfo.clear();
            batteryInfo.add(new Data("Level", String.valueOf(level)));
            batteryInfo.add(new Data("Health",health));
            batteryInfo.add(new Data("Status",status));
            batteryInfo.add(new Data("Connection",connection));
            batteryInfo.add(new Data("Voltage",String.valueOf(voltage).substring(0,2)+"."+String.valueOf(voltage).substring(2,3) +" V"));
            batteryInfo.add(new Data("Temp",String.valueOf(temp).substring(0,2)+"."+String.valueOf(temp).substring(2,3)+" c"));

            ListAdapter adapter=new ListAdapter(getContext(),batteryInfo);
            listView.setAdapter(adapter);
        }

    }




}


