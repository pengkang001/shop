package com.codewolf.shop.dao;

import com.codewolf.shop.domain.User;

import java.util.Map;

public interface IUserDao {
    User checkLogin(Map map);
}
