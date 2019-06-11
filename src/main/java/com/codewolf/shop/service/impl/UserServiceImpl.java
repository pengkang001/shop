package com.codewolf.shop.service.impl;

import com.codewolf.shop.dao.IUserDao;
import com.codewolf.shop.dao.impl.UserDaoImpl;
import com.codewolf.shop.domain.User;
import com.codewolf.shop.service.IUserService;

import java.util.Map;

public class UserServiceImpl  implements IUserService {
  IUserDao dao =  new UserDaoImpl();
    @Override
    public User checkLogin(Map map) {
        return dao.checkLogin(map);
    }
}
