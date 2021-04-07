package com.itis.kpfu.education.simononboard.spring.basics.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResult {
    private boolean success;
    private String data;
    private String message;
}
