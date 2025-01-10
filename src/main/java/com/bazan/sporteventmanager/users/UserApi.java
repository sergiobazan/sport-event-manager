package com.bazan.sporteventmanager.users;

import com.bazan.sporteventmanager.users.domain.User;

public interface UserApi {
    User getByEmail(String email);
}
