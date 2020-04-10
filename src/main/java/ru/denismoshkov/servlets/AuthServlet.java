package ru.denismoshkov.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.denismoshkov.beans.Client;
import ru.denismoshkov.dao.ClientDAO;
import ru.denismoshkov.enums.ClientCredential;
import ru.denismoshkov.enums.Page;
import ru.denismoshkov.exeptions.UnregistredClientException;
import ru.denismoshkov.utils.ServletUtil;
import ru.denismoshkov.utils.SessionUtil;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@WebServlet(name = "auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        ClientDAO clientDAO = new ClientDAO();
        Client client = null;
        try {
            client = clientDAO.get(clientLogin, clientPsswd);
            if (client == null) {

            }
        }catch (UnregistredClientException e) {
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
    }
}
