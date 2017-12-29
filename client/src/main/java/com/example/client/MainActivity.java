package com.example.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yhl.aidltest.IDemandListener;
import com.example.yhl.aidltest.IDemandManager;
import com.example.yhl.aidltest.MessageBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceConnection mConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IDemandListener.Stub listener = new IDemandListener.Stub() {
                    @Override
                    public void onDemandReceiver(final MessageBean msg) throws RemoteException {
                        //该方法运行在Binder线程池中，是非ui线程
                        Log.d("licl","client recevier msg");
                    }
                };
                mIDemandManager=IDemandManager.Stub.asInterface(iBinder);
                try {
                    mIDemandManager.registerListener(listener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        Intent intent=new Intent();
        intent.setAction("com.tengxun.aidl");
        intent.setPackage("com.example.yhl.aidltest");
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

    }

    private IDemandManager mIDemandManager;

}
