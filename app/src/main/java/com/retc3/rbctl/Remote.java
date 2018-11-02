package com.retc3.rbctl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.retc3.rbctl.rbctlsvc.Rbctl;
import com.retc3.rbctl.rbctlsvc.RBCtlGrpc;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Remote extends AppCompatActivity {

    static ManagedChannel channel;
    static RBCtlGrpc.RBCtlBlockingStub blockingStub;
    Logger logger = Logger.getLogger("remote");

    private void sendCommand(Rbctl.Command.Type t) {
        try {
            Rbctl.Command cmd = Rbctl.Command.newBuilder()
                    .setType(t)
                    .build();
            Rbctl.ControlResponse resp = Remote.blockingStub.control(cmd);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending command", e);
        }
    }

    public void onClickNext(View v) {
        this.sendCommand(Rbctl.Command.Type.NEXT);
    }

    public void onClickPlayPause(View v) {
        this.sendCommand(Rbctl.Command.Type.PLAY_PAUSE);
    }

    public void onClickPrevious(View v) {
        this.sendCommand(Rbctl.Command.Type.PREVIOUS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        logger.info("Creating channels and stuff");
        Remote.channel = ManagedChannelBuilder.forAddress("192.168.1.1", 12123)
                .usePlaintext(true)
                .build();
        Remote.blockingStub = RBCtlGrpc.newBlockingStub(Remote.channel);
        logger.info(String.format("Are they null: %b %b", Remote.channel == null, Remote.blockingStub == null));
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
