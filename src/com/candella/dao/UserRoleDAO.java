package com.candella.dao;

import java.util.List;

import com.candella.entity.UserRole;

public interface UserRoleDAO {
    UserRole getUserRoleById(String userRoleId);
    List<UserRole> getUserRole();
}