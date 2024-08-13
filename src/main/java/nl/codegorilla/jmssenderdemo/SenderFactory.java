package nl.codegorilla.jmssenderdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SenderFactory {
    @Autowired
    private JmsTemplate jmsTemplate;

    Sender createSender(String name) {
        return new Sender(name, jmsTemplate);
    }
}

class Sender {
    private final String name;
    private final JmsTemplate jmsTemplate;

    Sender(String name, JmsTemplate jmsTemplate) {
        this.name = name;
        this.jmsTemplate = jmsTemplate;
        jmsTemplate.setPubSubDomain(true);
    }

    public void send(String message) {
        var announcement = Map.of(
                "name", name,
                "message", message
        );
        jmsTemplate.convertAndSend(announcement);
    }
}
