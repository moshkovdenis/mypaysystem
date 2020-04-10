package ru.denismoshkov.beans;

import java.util.List;

public interface Person {
    String getFullName();

    void setAccounts(List<Account> personAccounts);
}
