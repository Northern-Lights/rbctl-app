package com.retc3.rbctl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.retc3.rbctl.rbctlsvc.Rbctl;
import com.retc3.rbctl.rbctlsvc.RBCtlGrpc;

public class Remote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
    }
}
