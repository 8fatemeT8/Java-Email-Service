package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.dto.EmailWithLinkDto;
import com.example.email.utils.EmailUtil;
import com.example.email.utils.ThreadUtil;
import com.example.email.utils.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class BaseService {

    private EmailUtil emailUtil;

    public BaseService(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }


    public String preparingToSend(EmailDto emailDto){
        ThreadUtil.createThreadAndStart(() -> {
            emailUtil.sendEmail(emailDto.getEmail(),emailDto.getSubject(),emailDto.getText());
            System.out.println("email to : "+emailDto.getEmail()+"----------------------------------------------------------------");
            System.out.println("email subject : "+emailDto.getSubject()+"----------------------------------------------------------------");
        });
        return "sent";
    }

    public String preparingToSendWithLink(EmailWithLinkDto dto){
        ThreadUtil.createThreadAndStart(()->{
            try {
                emailUtil.sendEmailWithLink(dto.getEmail(),dto.getSubject(),dto.getText(),dto.getUrl());
            } catch (MessagingException e) {
                throw new ResponseException(HttpStatus.BAD_GATEWAY.value(), "error has occurred during sending email");
            }
        });

        return "sent";
    }

}
