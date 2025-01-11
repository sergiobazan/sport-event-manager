package com.bazan.sporteventmanager.shared;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    String getUserEmailFromToken(String jwtToken);
    boolean isValidToken(String jwtToken, UserDetails userDetails);
}
