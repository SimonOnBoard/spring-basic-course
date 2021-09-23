package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import com.itis.kpfu.education.simononboard.spring.basics.dto.SmsInfo;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.SmsSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class SmsSenderController {
    private final SmsSender smsSender;

    @PermitAll
    @GetMapping("/sendSms")
    public String sendSmsMessage(@RequestParam String phone, @RequestParam String text) {
        return smsSender.sendSms(phone, text);
    }

    @PermitAll
    @GetMapping("/checkStatus")
    public String checkSmsStatus(@ModelAttribute SmsInfo smsInfo){
        return smsSender.checkSmsStatus(smsInfo);
    }
}
