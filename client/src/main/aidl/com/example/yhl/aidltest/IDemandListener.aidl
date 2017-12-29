// IDemandListener.aidl
package com.example.yhl.aidltest;
import com.example.yhl.aidltest.MessageBean;
// Declare any non-default types here with import statements

interface IDemandListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onDemandReceiver(in MessageBean msg);
}
