package org.jms;


import javax.jms.*;
import javax.naming.*;

public class FireAlarmJMS {
    public void raise() {
        try {
            Context ctx = new InitialContext();
            TopicConnectionFactory topicConnectionFactory =
                    (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
            Topic topic = (Topic) ctx.lookup("Alarms");
            TopicConnection topicConn = topicConnectionFactory.createTopicConnection();
            TopicSession topicSess =
                    topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher topicPub = topicSess.createPublisher(topic);
            TextMessage msg = topicSess.createTextMessage();
            msg.setText("Fire!");
            topicPub.publish(msg);
        } catch (Exception e) {
            System.out.println("FireAlarmJMS -> Entrou no catch");
        }
    }
}