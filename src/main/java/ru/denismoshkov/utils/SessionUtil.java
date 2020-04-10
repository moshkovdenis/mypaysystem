package ru.denismoshkov.utils;

import ru.denismoshkov.beans.Client;
import ru.denismoshkov.enums.ClientCredential;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionUtil {

    public static Map<String, String> readClientCredentials(HttpServletRequest httpServletRequest) {
        Map<String, String> result = new HashMap<>();
        String clientFirstName = httpServletRequest.getParameter(ClientCredential.FIRST_NAME.getClientCredential());
        String clientSecondName = httpServletRequest.getParameter(ClientCredential.SECOND_NAME.getClientCredential());
        String clientSurname = httpServletRequest.getParameter(ClientCredential.SURNAME.getClientCredential());
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        result.put(ClientCredential.FIRST_NAME.getClientCredential(), clientFirstName);
        result.put(ClientCredential.SECOND_NAME.getClientCredential(), clientSecondName);
        result.put(ClientCredential.SURNAME.getClientCredential(), clientSurname);
        result.put(ClientCredential.LOGIN.getClientCredential(), clientLogin);
        result.put(ClientCredential.PSSWD.getClientCredential(), clientPsswd);
        return result;
    }

    public static void fillSession(HttpSession httpSession, Client client) {
        httpSession.setAttribute(ClientCredential.FIRST_NAME.getClientCredential(), client.getFirstname());
        httpSession.setAttribute(ClientCredential.SECOND_NAME.getClientCredential(), client.getSecondname());
        httpSession.setAttribute(ClientCredential.SURNAME.getClientCredential(), client.getSurname());
        httpSession.setAttribute(ClientCredential.LOGIN.getClientCredential(), client.getLogin());
        httpSession.setAttribute(ClientCredential.PSSWD.getClientCredential(), client.getPsswd());
        httpSession.setMaxInactiveInterval(300);
    }
}
