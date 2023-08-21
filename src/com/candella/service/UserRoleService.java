package com.candella.service;

import java.util.List;

import com.candella.entity.UserRole;

public interface UserRoleService {
    UserRole getUserRoleById(String userRoleId);
    List<UserRole> getUserRole();
}
