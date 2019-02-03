package com.webtrekk.email.service.service;

import com.webtrekk.email.service.avro.Email;

/**
 * The interface Email service.
 */
public interface EmailService {

    /**
     * Send email.
     *
     * @param email the email
     */
     void sendEmail(Email email);
}
