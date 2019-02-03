package com.webtrekk.email.service.api;

import com.webtrekk.email.service.configuration.ApplicationConstant;
import com.webtrekk.email.service.dto.EmailDTO;
import com.webtrekk.email.service.dto.ResponseDTO;
import com.webtrekk.email.service.publisher.EmailPublisher;
import com.webtrekk.email.service.util.EmailUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Email controller.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailPublisher emailPublisher;


    /**
     * Send message to kafka topic response entity.
     *
     * @param email the email
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping(value = "/email")
    @ApiOperation(value = "send Email")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Email Accepted Successful"),
            @ApiResponse(code = 400, message = "Validation Error"),
            @ApiResponse(code = 500, message = "Server error occurred")})
    public ResponseEntity<ResponseDTO> sendMessageToKafkaTopic(@ApiParam("Email payload")@Valid @RequestBody EmailDTO email) {

           this.emailPublisher.sendMessage(EmailUtil.BuildEmail(email));
           LOGGER.info("Email Accepted Successful");
           return ResponseEntity.accepted().body(
                   ResponseDTO.builder()
                           .status(ApplicationConstant.ACCEPTED)
                           .message(ApplicationConstant.EMAIL_SUCCESSFULLY_ACCEPTED)
                           .build());

    }


}
