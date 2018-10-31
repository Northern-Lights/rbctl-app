package com.retc3.rbctl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.retc3.rbctl.rbctlsvc.Rbctl;
import com.retc3.rbctl.rbctlsvc.RBCtlGrpc;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Remote extends AppCompatActivity {

    static ManagedChannel channel;
    static RBCtlGrpc.RBCtlBlockingStub blockingStub;

    public void onClickNext(View v) {
        Rbctl.Command cmd = Rbctl.Command.newBuilder()
                .setType(Rbctl.Command.Type.NEXT)
                .build();
        Rbctl.ControlResponse resp = Remote.blockingStub.control(cmd);
    }

    public void onClickPlayPause(View v) {
        Rbctl.Command cmd = Rbctl.Command.newBuilder()
                .setType(Rbctl.Command.Type.PLAY_PAUSE)
                .build();
        Rbctl.ControlResponse resp = Remote.blockingStub.control(cmd);
    }

    public void onClickPrevious(View v) {
        Rbctl.Command cmd = Rbctl.Command.newBuilder()
                .setType(Rbctl.Command.Type.PREVIOUS)
                .build();
        Rbctl.ControlResponse resp = Remote.blockingStub.control(cmd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        Remote.channel = ManagedChannelBuilder.forAddress("192.168.1.1", 12123)
                .usePlaintext(true)
                .build();
        Remote.blockingStub = RBCtlGrpc.newBlockingStub(Remote.channel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (Remote.blockingStub != null) {
            try {
                Remote.channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Remote.channel.shutdownNow();
            } finally {
                Remote.channel = null;
                Remote.blockingStub = null;
            }
        }
    }
}
