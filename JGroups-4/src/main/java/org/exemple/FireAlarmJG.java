package org.exemple;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

public class FireAlarmJG extends ReceiverAdapter {
    private JChannel channel;

    public void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("AlarmChannel");
    }

    public void sendAlarm() throws Exception {
        String message = "Fire!";
        channel.send(new Message(null, message));
        System.out.println("FireAlarmJG -> alarm.send:" + message);
    }

    public void stop() {
        channel.close();
    }

}
