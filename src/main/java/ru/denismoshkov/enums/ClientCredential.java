package ru.denismoshkov.enums;

public enum ClientCredential {
    FIRST_NAME("firstname"),
    SECOND_NAME("secondname"),
    SURNAME("surname"),
    LOGIN("login"),
    PSSWD("psswd");

    private String clientCredential;

    ClientCredential(String clientCredential) {
        this.clientCredential = clientCredential;
    }

    public String getClientCredential() {
        return clientCredential;
    }
}
