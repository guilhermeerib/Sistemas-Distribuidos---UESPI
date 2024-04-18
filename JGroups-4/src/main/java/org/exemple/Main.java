package org.exemple;

public class Main {
    public static void main(String[] args) {
        FireAlarmJG fireAlarm = new FireAlarmJG();
        FireAlarmConsumerJG consumer = new FireAlarmConsumerJG();

        try {
            fireAlarm.start();
            consumer.start();
            // Simular o envio de alarme após alguns segundos
            Thread.sleep(2000);
            fireAlarm.sendAlarm();
            // Esperar um pouco para garantir que a mensagem seja processada
            Thread.sleep(2000);
            // Parar os objetos depois que a simulação terminar
            fireAlarm.stop();
            consumer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

