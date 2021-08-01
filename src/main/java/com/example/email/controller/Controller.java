package com.example.email.controller;

import com.example.email.dto.EmailDto;
import com.example.email.dto.EmailWithLinkDto;
import com.example.email.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class Controller {

    private BaseService service;

    public Controller(BaseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailDto emailDto) {
        return ResponseEntity.ok().body(service.preparingToSend(emailDto));
    }

    @PostMapping("/with-link")
    public ResponseEntity<?> sendEmailWithLink(@RequestBody EmailWithLinkDto dto) {
        return ResponseEntity.ok().body(service.preparingToSendWithLink(dto));
    }
}
