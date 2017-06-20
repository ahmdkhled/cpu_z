package com.ahmedkhaled.cpuz.Data;


public interface OnReceiveListener{

     void onDataReceived(int level,String health ,String status,String conection,int voltage,int temp);
 }
