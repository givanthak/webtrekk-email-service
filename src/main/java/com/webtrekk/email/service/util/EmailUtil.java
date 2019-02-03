package com.webtrekk.email.service.util;

import com.webtrekk.email.service.avro.Attachment;
import com.webtrekk.email.service.avro.Email;
import com.webtrekk.email.service.dto.AttachmentDTO;
import com.webtrekk.email.service.dto.EmailDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Email util.
 */
public class EmailUtil {

    /**
     * Build email email.
     *
     * @param email the email
     * @return the email
     */
    public static Email BuildEmail(EmailDTO email) {

        List<Attachment> attachments = new ArrayList<Attachment>();
        if (!StringUtils.isEmpty(email.getAttachments()))
            for (AttachmentDTO attachment : email.getAttachments()) {
                attachments.add(Attachment.newBuilder()
                        .setName(attachment.getName())
                        .setAttachmentURI(attachment.getAttachmentURI())
                        .build());
            }

        return Email.newBuilder()
                .setFrom(email.getFrom())
                .setTo(email.getTo())
                .setBcc(email.getBcc())
                .setCc(email.getCc())
                .setSubject(email.getSubject())
                .setBody(email.getBody())
                .setAttachments(attachments)
                .build();
    }
}