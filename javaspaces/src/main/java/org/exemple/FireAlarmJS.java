package org.exemple;

import net.jini.space.JavaSpace;

public class FireAlarmJS {
    public void raise() {
        try {
            JavaSpace space = SpaceAcessor.findSpace("AlarmSpace");
            AlarmTupleJS tuple = new AlarmTupleJS("Fire");
            space.write(tuple, null, 60 * 60 * 1000);
        } catch (Exception e) {

        }
    }

}


