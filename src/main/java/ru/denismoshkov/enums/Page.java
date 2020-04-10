package ru.denismoshkov.enums;

public enum Page {
    INDEX_PAGE("index.jsp"),
    REG_PAGE("/views/registration.jsp"),
    SUCCESS_REG_PAGE("/views/successRegClient.jsp"),
    AUTH_PAGE("/views/auth.jsp"),
    SUCCESS_AUTH_PAGE("/views/successAuthClient.jsp"),
    ERROR_PAGE("/views/error.jsp");

    private String page;

    public String getPage() {
        return page;
    }

    Page(String page) {
        this.page = page;
    }
}
