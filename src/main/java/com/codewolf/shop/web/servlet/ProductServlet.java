package com.codewolf.shop.web.servlet;

import com.codewolf.shop.domain.Product;
import com.codewolf.shop.qo.PageResult;
import com.codewolf.shop.qo.ProductQueryObject;
import com.codewolf.shop.service.IProductService;
import com.codewolf.shop.service.impl.ProductServiceImpl;
import com.codewolf.shop.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        IProductService service = new ProductServiceImpl();
        if (cmd == null || cmd.trim().equals("list"))
            list(req, resp, service);
        else if (cmd.trim().equals("delete"))
            delete(req, resp, service);
        else if (cmd.trim().equals("edit"))
            edit(req, resp, service);
        else if (cmd.trim().equals("update"))
            update(req, resp, service);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp, IProductService service) throws ServletException, IOException {
        String strId = req.getParameter("id");
        if (!StringUtil.isNull(strId)) {
            Product product = service.get(Long.parseLong("strId"));
            if (product != null)
                req.setAttribute("product", product);
        }
        req.getRequestDispatcher("WEB-INF/views/product/input.jsp")
                .forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp, IProductService service) throws ServletException, IOException {
        String id = req.getParameter("id");
        String productSn = req.getParameter("productSn");
        String productName = req.getParameter("productName");
        byte[] bytes = productName.getBytes("ISO-8859-1");
        productName = new String(bytes, "utf-8");
        String salePrice = req.getParameter("salePrice");
        String account = req.getParameter("account");
        String dirId = req.getParameter("dirId");
        Product product = new Product();
        product.setProductName(productName);
        product.setProductSn(productSn);
        if (!StringUtil.isNull(salePrice))
            product.setSalePrice(new BigDecimal(salePrice));
        if (!StringUtil.isNull(account))
            product.setAccount(Integer.parseInt(account));
        if (!StringUtil.isNull(dirId))
            product.setDirId(Long.parseLong(dirId));
        if (StringUtil.isNull(id))
            service.save(product);
        else {
            product.setId(Long.parseLong(id));
            service.update(product);
        }
        req.getRequestDispatcher("/product?cmd=list").forward(req, resp);
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp, IProductService service) throws ServletException, IOException {
        String strId = req.getParameter("id");
        if (!StringUtil.isNull(strId)) {
            Long id = Long.parseLong(strId);
            service.delete(id);
        }
        req.getRequestDispatcher("/product?cmd=list").forward(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp, IProductService service) throws ServletException, IOException {
        String key = req.getParameter("key");
        String min = req.getParameter("min");
        String max = req.getParameter("max");
        String isEmpty = req.getParameter("isEmpty");
        String dirId = req.getParameter("dirId");
        ProductQueryObject qo = new ProductQueryObject();
        if (!StringUtil.isNull(key))
            qo.setKey(key);
        if (!StringUtil.isNull(min))
            qo.setMin(new BigDecimal(min));
        if (!StringUtil.isNull(max))
            qo.setMax(new BigDecimal(max));
        if (!StringUtil.isNull(isEmpty))
            qo.setIsEmpty(Boolean.parseBoolean(isEmpty));
        if (!StringUtil.isNull(dirId))
            qo.setDirId(Long.parseLong(dirId));
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        if (!StringUtil.isNull(currentPage))
            qo.setCurrentPage(Integer.parseInt(currentPage));
        if (!StringUtil.isNull(pageSize))
            qo.setPageSize(Integer.parseInt(pageSize));

        PageResult pageResult = service.getPageResult(qo);
        req.setAttribute("pageResult", pageResult);
        qo.setCurrentPage(pageResult.getCurrentPage());
        List<Product> products = service.list(qo);
        req.setAttribute("products", products);
        req.setAttribute("qo", qo);
        req.getRequestDispatcher("WEB-INF/views/product/list.jsp")
                .forward(req, resp);
    }
}
