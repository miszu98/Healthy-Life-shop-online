package com.simpleshop.Services;

import com.simpleshop.Models.Email;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MailSenderService {

    private JavaMailSender javaMailSender;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Email email) throws MessagingException {
        var message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        message.setContent("<h1>Welcome </h1><br> <h3> We glad you're join to us. Have a nice shopping</h3><a href='http://localhost:8080/main'><img src='https://i.imgur.com/kg2SEcY.jpg'></a>", "text/html");
        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        javaMailSender.send(message);
    }

   public void sendMailWithOrder(Email email) throws MessagingException {
        var message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        message.setContent(email.getText(), "text/html");
        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        javaMailSender.send(message);
   }
}
