package org.example;

import org.jgroups.JChannel;
import org.jgroups.Message;

public class FireAlarmJG {
    public void raise() {
        try {
            JChannel channel = new JChannel();
            channel.connect("AlarmChannel");

            Message msg = new Message(null, null, "Fire!");
            channel.send(msg);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("FireAlarmJG-> catch error:" + e);
        }
    }
}
