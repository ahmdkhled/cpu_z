package com.ahmedkhaled.cpuz.Data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 6/17/2017.
 */

public class Battery  extends BroadcastReceiver {

    int level, health,status,connection,voltage,temp;

    ArrayList<String> info;
    Bundle bundle;
    OnReceiveListener onReceiveListener;

    public Battery(OnReceiveListener onReceiveListener) {
        info=new ArrayList<>();
        bundle=new Bundle();
        this.onReceiveListener=onReceiveListener;
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {

            level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -10);
            health =intent.getIntExtra(BatteryManager.EXTRA_HEALTH,-10);
            status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-10);
            connection=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-10);
            voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,-10);
            temp=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,-10);


            onReceiveListener.onDataReceived(level,getHealth(health),getStatus(status),getConnection(connection),voltage,temp);

        }
    }

    String getHealth(int healthCode){
        switch (healthCode){
            case BatteryManager.BATTERY_HEALTH_GOOD:return "Good";
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:return "UnKnown";
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:return "OverHeated";
            case BatteryManager.BATTERY_HEALTH_DEAD:return "Dead";
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:return "OverVoltage";
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:return "Failed";
            case BatteryManager.BATTERY_HEALTH_COLD:return "Cold";


        }

        return "failed to get health";
    }

    String getStatus(int statusCode){
        switch (statusCode){
            case BatteryManager.BATTERY_STATUS_UNKNOWN:return "UnKnown";
            case BatteryManager.BATTERY_STATUS_CHARGING:return "Charging";
            case BatteryManager.BATTERY_STATUS_DISCHARGING:return "DisCharging";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:return "NotCharging";
            case BatteryManager.BATTERY_STATUS_FULL:return "Full";
        }

        return "failed to get status";
    }

    String getConnection(int connectionCode){
        switch (connectionCode){
            case BatteryManager.BATTERY_PLUGGED_AC:return "Ac Plugged";
            case BatteryManager.BATTERY_PLUGGED_USB:return "Usb Plugged";
            case BatteryManager.BATTERY_PLUGGED_WIRELESS:return "Wireless Plugged";

        }

        return "unknown connection";
    }




    }









