package ru.denismoshkov.enums;

public enum FormParametr {
    ENTER_PARAMETR("enter"),
    REG_PARAMETR("reg");

    private String formParametr;

    public String getFormParametr() {
        return formParametr;
    }

    FormParametr(String formParametr) {
        this.formParametr = formParametr;
    }
}
