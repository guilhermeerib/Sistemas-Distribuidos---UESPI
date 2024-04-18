package org.exemple;

public class Main {
    public static void main(String[] args) {
        FireAlarmJS alarm = new FireAlarmJS();
        alarm.raise();

        FireAlarmConsumerJS alarmCall = new FireAlarmConsumerJS();
        String msg = alarmCall.await();
        System.out.println("Alarm received: " + msg);
    }


}