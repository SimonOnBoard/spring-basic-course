package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;


import com.itis.kpfu.education.simononboard.spring.basics.dto.SmsInfo;

public interface SmsSender {
    String sendSms(String phone,String text);

    String checkSmsStatus(SmsInfo smsInfo);
}
