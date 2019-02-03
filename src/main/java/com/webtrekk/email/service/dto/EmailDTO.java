package com.webtrekk.email.service.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Mail.
 */
@Getter
@Setter
@ToString
@Builder
public class EmailDTO {

    @NotNull(message = "Email from address cannot be empty")
    @Email(message = "Invalid format from email address")
    private String from;

    @NotNull(message = "Email to address cannot be empty")
    @Email(message = "Invalid format to email address")
    private String to;

    @Email(message = "Invalid format cc email address")
    private String cc;

    @Email(message = "Invalid format bcc email address")
    private String bcc;

    @NotNull(message = "Email subject cannot be empty")
    private String subject;

    @NotNull(message = "Email body cannot be empty")
    private String body;

    private List<AttachmentDTO> attachments;

}