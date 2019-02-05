package com.webtrekk.email.service.service;

import com.webtrekk.email.service.avro.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class EmailServiceImpl implements EmailService {

    public static Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(Email email) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(email.getFrom());
            mimeMessageHelper.setTo(email.getFrom());
            mimeMessageHelper.setCc(email.getCc());
            mimeMessageHelper.setBcc(email.getBcc());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getBody());
            if(!StringUtils.isEmpty(email.getAttachments()))
                addAttachment(email, mimeMessageHelper);
            emailSender.send(mimeMessage);
            LOGGER.info("Email Successful send to {}", email.getTo());
        } catch (Exception ex){
            LOGGER.error("Email send fail to {} error occurred {}", email.getTo(), ex.getLocalizedMessage());
        }
    }

    private void addAttachment(Email email, MimeMessageHelper mimeMessageHelper) {
        email.getAttachments().stream().forEach(attachment -> {
            try {
                URL url = new URL(attachment.getAttachmentURI());
                URLConnection connection = url.openConnection();
                ByteArrayDataSource dataSource = new ByteArrayDataSource(url.openStream(), connection.getContentType());
                mimeMessageHelper.addAttachment(attachment.getName(), dataSource);
            } catch (IOException | MessagingException ex) {
                LOGGER.error("Email Attachment Could't download {} error occurred {}", attachment.getAttachmentURI(), ex.getLocalizedMessage());
            }
        });
    }

}
