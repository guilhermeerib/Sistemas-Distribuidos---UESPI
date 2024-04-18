package org.example;

import org.jgroups.JChannel;
import org.jgroups.Message;

public class FireAlarmConsumerJG {
    public String await() {
        try {
            JChannel channel = new JChannel();
            channel.connect("AlarmChannel");

            Message msg = (Message) channel.receive(0);
            return (String) msg.getObject();
        } catch (Exception e) {
            System.out.println();
            return null;
        }
    }
}

