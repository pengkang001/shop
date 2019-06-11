package com.codewolf.shop.service;

import com.codewolf.shop.domain.User;

import java.util.Map;

public interface IUserService {
    User checkLogin(Map map);
}
