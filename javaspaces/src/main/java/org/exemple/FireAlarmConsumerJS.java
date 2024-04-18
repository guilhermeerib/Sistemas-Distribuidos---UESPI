package org.exemple;

import net.jini.space.JavaSpace;

public class FireAlarmConsumerJS {
    public String await() {
        try {
            JavaSpace space = SpaceAccessor.findSpace();
            AlarmTupleJS template = new AlarmTupleJS("Fire!");
            AlarmTupleJS recvd = (AlarmTupleJS) space.read(template, null, Long.MAX_VALUE);
            return recvd.alarmType;
        } catch (Exception e) {
            return null;
        }
    }
}