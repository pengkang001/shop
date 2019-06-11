package com.codewolf.shop.web.servlet;

import com.codewolf.shop.domain.User;
import com.codewolf.shop.service.IUserService;
import com.codewolf.shop.service.impl.UserServiceImpl;
import com.codewolf.shop.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("USER_IN_SESSION");
        if (user != null) {
            req.getRequestDispatcher("/product")
                    .forward(req, resp);
            return;
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (StringUtil.isNull(username) ||  StringUtil.isNull(password))
        {
            req.setAttribute("msg","用户名或密码错");
            req.getRequestDispatcher("/login.jsp")
                    .forward(req, resp);
            return;
        }
        Map map = new HashMap();
        map.put("username",username);
        map.put("password",password);
        IUserService service = new UserServiceImpl();
        User check = service.checkLogin(map);
        if (check == null){
            req.getRequestDispatcher("/login.jsp")
                    .forward(req, resp);
            return;
        }
        req.getSession().setAttribute("USER_IN_SESSION",check);
        req.getRequestDispatcher("/product")
                .forward(req, resp);
    }

}
