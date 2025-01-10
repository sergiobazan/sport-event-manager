package com.bazan.sporteventmanager.config.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String getUserEmailFromToken(String jwtToken) {
        return "";
    }

    public boolean isValidToken(String jwtToken, UserDetails userDetails) {
        return false;
    }
}
