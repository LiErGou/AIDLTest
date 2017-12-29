// IDemandManager.aidl
package com.example.yhl.aidltest;
import com.example.yhl.aidltest.MessageBean;
import com.example.yhl.aidltest.IDemandListener;
// Declare any non-default types here with import statements

interface IDemandManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     MessageBean getDemand();
     void setDemandIn(in MessageBean msg);
     void setDemandOut(out MessageBean msg);
     void setDemanInOut(inout MessageBean msg);
     void registerListener(IDemandListener listener);
     void unregisterListener(IDemandListener listener);
}
