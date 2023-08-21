package com.candella.service;

import java.util.List;

import com.candella.dao.UserRoleDAO;
import com.candella.dao.UserRoleDAOImpl;
import com.candella.entity.UserRole;

public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleDAO userRoleDAO;

    public UserRoleServiceImpl() {
        userRoleDAO = new UserRoleDAOImpl();
    }

    @Override
    public UserRole getUserRoleById(String userRoleId) {
        return userRoleDAO.getUserRoleById(userRoleId);
    }

	@Override
	public List<UserRole> getUserRole() { 
		
		 return userRoleDAO.getUserRole();	}
}
