package com.example.SpringBootDemo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
public class SpringBootDemoApplication {

    private static final Logger LOGGER = Logger.getLogger(SpringBootDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);

        System.out.println("Preparing to send message...");
        LOGGER.info("message sending");
        String message = "Hello, Dear, this is message for security";
        String subject = "Confirmation";
        String to = "kuldeepkamble65@gmail.com";
        String from = "omkarandhare2317@gmail.com";

        sendEmail(message, subject, to, from);
    }

    // responsible for to send mail
    private static void sendEmail(String message, String subject, String to, String from) {

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        System.out.println("PROPERTIES" + properties);


        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", true);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("omkarandhare2317@gmail.com", "jabuuapizyoolffw");
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(from);

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            mimeMessage.setSubject(subject);

            mimeMessage.setText(message);

            Transport.send(mimeMessage);

            System.out.println("sent success.....");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
