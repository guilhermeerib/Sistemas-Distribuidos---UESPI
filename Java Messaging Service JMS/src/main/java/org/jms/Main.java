package org.jms;


public class Main {
    public static void main(String[] args) {
        FireAlarmConsumerJMS alarmCall = new FireAlarmConsumerJMS();
        String msg = alarmCall.await();
        System.out.println("Alarm received: "+msg);
    }
}