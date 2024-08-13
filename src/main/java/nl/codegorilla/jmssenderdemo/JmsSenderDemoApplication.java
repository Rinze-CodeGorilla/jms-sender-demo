package nl.codegorilla.jmssenderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JmsSenderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsSenderDemoApplication.class, args);
    }

    JmsSenderDemoApplication(SenderFactory senderFactory) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        Sender sender = senderFactory.createSender(s.nextLine().trim());
        while(true) {
            System.out.println("Please enter the message to send: ");
            String message = s.nextLine().trim();
            sender.send(message);
        }
    }
}
