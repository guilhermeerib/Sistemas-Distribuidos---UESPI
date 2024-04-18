package com.uespi.sd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.Receiver;
import org.jgroups.ReceiverAdapter;

public class FireAlarmConsumerJG extends ReceiverAdapter {
    public void await() {
        try {
            JChannel channel = new JChannel();
            channel.connect("AlarmChannel");
            Message msg = (Message) channel.getReceiver();
            receive(msg);
        } catch (Exception e) {
            System.out.println("FireAlarmConsumerJG -> catch error: " + e);
//            return null;
        }
    }

    public void start() throws Exception {
        JChannel channel = new JChannel();
        channel.setReceiver((Receiver) this);
        channel.connect("AlarmChannel");
        eventLoop(channel);
        channel.close();
    }
    
    public void receive(Message msg) {
        System.out.println(msg.getSrc() + ": " + msg.getObject());
    }

    public void viewAccepted(View new_view) {
        System.out.println("** Connected users: " + new_view);
    }

    private void eventLoop( JChannel channel) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //View view=channel.getView();
        //viewAccepted(view);
        while(true) {
            try {
                //line="[" + user_name + "] " + line;
                Message msg= (Message) channel.getReceiver();
                receive(msg);
            }
            catch(Exception e) {
            }
        }
    }
}

