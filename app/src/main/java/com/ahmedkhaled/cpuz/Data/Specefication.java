package com.ahmedkhaled.cpuz.Data;

import android.os.Build;

import com.ahmedkhaled.cpuz.Model.Data;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 6/17/2017.
 */

public class Specefication {

    private ArrayList<Data> specifications=new ArrayList<>();

    public ArrayList<Data> getDeviceSpecification(){
        specifications.clear();
        specifications.add(new Data("Brand",Build.BRAND));
        specifications.add(new Data("Model",Build.MODEL));
        specifications.add(new Data("Time",String.valueOf(Build.TIME)));
        specifications.add(new Data("Serial",Build.SERIAL));

        return specifications;

    }


    public ArrayList<Data> getSystemeSpecification(){
        specifications.clear();
        specifications.add(new Data("Hardware",Build.HARDWARE));
        specifications.add(new Data("Release",Build.VERSION.RELEASE));
        specifications.add(new Data("Board",Build.BOARD));
        specifications.add(new Data("BootLoader",Build.BOOTLOADER));
        specifications.add(new Data("Host",Build.HOST));

        return specifications;

    }

}
