package com.retc3.rbctl;

// TODO: stop using main thread for event handling & gRPC

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    // TODO: need a better way of handling connected/not-connected state
    private void setClient() {
        if (Remote.channel != null) {
            logger.info("Shutting down current connection");
            try {
                Remote.channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Couldn't shutdown current connection", e);
                Remote.channel.shutdownNow();
            }
        }

        // TODO: user's previous input should be persisted
        // https://developer.android.com/training/data-storage/shared-preferences
        EditText hostInput = findViewById(R.id.input_host);
        EditText portInput = findViewById(R.id.input_port);
        String h = hostInput.getText().toString();
        String s_port = portInput.getText().toString();
        int p;
        try {
            p = Integer.parseInt(s_port);
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Couldn't parse port input", e);
            return;
        }

        Remote.channel = ManagedChannelBuilder.forAddress(h, p)
                .usePlaintext(true)
                .build();
        Remote.blockingStub = RBCtlGrpc.newBlockingStub(Remote.channel);
        logger.info("Host and port set");
    }

    private void sendCommand(Rbctl.Command.Type t) {
        try {
            Rbctl.Command cmd = Rbctl.Command.newBuilder()
                    .setType(t)
                    .build();
            Rbctl.ControlResponse resp = Remote.blockingStub.
                    withDeadlineAfter(1, TimeUnit.SECONDS).
                    control(cmd);
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "Channel or stub are nil; setting...");
            setClient();
            Toast.makeText(
                    this.getApplicationContext(),
                    "Connection to Rhythmbox reset",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending command", e);
            Toast.makeText(
                    getApplicationContext(),
                    "An error occurred",
                    Toast.LENGTH_SHORT).show();
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
