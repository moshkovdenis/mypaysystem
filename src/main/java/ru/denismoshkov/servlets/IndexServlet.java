package ru.denismoshkov.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.denismoshkov.enums.FormParametr;
import ru.denismoshkov.enums.Page;
import ru.denismoshkov.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String enterCommand = httpServletRequest.getParameter(FormParametr.ENTER_PARAMETR.getFormParametr());
        String regCommand = httpServletRequest.getParameter(FormParametr.REG_PARAMETR.getFormParametr());
        String pageCommand = Page.INDEX_PAGE.getPage();
        if (enterCommand != null) {
            pageCommand = Page.AUTH_PAGE.getPage();
        } else if (regCommand != null) {
            pageCommand = Page.REG_PAGE.getPage();
        }
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, pageCommand);
    }
}
