package ru.denismoshkov.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.denismoshkov.beans.Client;
import ru.denismoshkov.dao.ClientDAO;
import ru.denismoshkov.enums.ClientCredential;
import ru.denismoshkov.enums.Page;
import ru.denismoshkov.utils.ServletUtil;
import ru.denismoshkov.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@WebServlet(name = "regClient", urlPatterns = "/regClient")
public class RegClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, String > clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);

        Client client = new Client(
                clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                clientCredentials.get(ClientCredential.PSSWD.getClientCredential()),
                clientCredentials.get(ClientCredential.FIRST_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SECOND_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SURNAME.getClientCredential()));
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
    }
}
