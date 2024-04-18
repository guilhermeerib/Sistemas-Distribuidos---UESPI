package org.jms;

import javax.jms.*;
import javax.naming.*;

public class FireAlarmConsumerJMS {
    public String await() {
        try {
            Context ctx = new InitialContext();
            TopicConnectionFactory topicConnectionFactory =
                    (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
            Topic topic = (Topic) ctx.lookup("Alarms");
            TopicConnection topicConn =
                    topicConnectionFactory.createTopicConnection();
            TopicSession topicSess = topicConn.createTopicSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSub = topicSess.createSubscriber(topic);
            topicSub.start();
            TextMessage msg = (TextMessage) topicSub.receive();
            return msg.getText();
        } catch (Exception e) {
            System.out.println("FireAlarmConsumerJMS -> catch exception: " + e);
            return null;
        }
    }
}