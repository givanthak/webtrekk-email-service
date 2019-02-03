package com.webtrekk.email.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Attachment.
 */
@Getter
@Setter
@ToString
@Builder
public class AttachmentDTO {

    private String name;
    private String attachmentURI;

}
