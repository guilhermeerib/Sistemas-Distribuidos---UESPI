package org.exemple;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

public class FireAlarmConsumerJG extends ReceiverAdapter {
    private JChannel channel;

    public void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("AlarmChannel");
    }

    @Override
    public void receive(Message msg) {
        System.out.println("FireAlarmConsumerJG -> consumer.receive: " + msg.getObject());
    }

    public void stop() {
        channel.close();
    }
}
