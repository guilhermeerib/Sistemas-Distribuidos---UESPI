package org.example;

public class Main {
    public static void main(String[] args) {
//        System.setProperty("java.net.preferIPv4Stack" , "true");
        FireAlarmJG alarm = new FireAlarmJG();
        alarm.raise();

        FireAlarmConsumerJG alarmCall = new FireAlarmConsumerJG();
        String msg = alarmCall.await();
        System.out.println("Main -> Alarm received: " + msg);
    }
}