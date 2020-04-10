package ru.denismoshkov.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaySystemCore {
    private List<Account> paySystemAccounts;
    private List<Person> paySystemClients;
    private Map <Client, List<Account>> paySystemClientAccounts;


    public void initClientAccounts() {

    }

    public void showAllAccounts() {
        System.out.println("Список всех счетов: ");
        for (Account account : paySystemAccounts) {
            System.out.println(account.toString());
        }
        System.out.println();
    }

    public void showAllClients() {

    }

    public void showAllClientAccounts() {
        for (Map.Entry<Client, List<Account>> entry : paySystemClientAccounts.entrySet()) {
            Client client =entry.getKey();
            System.out.println(client.getFullName());
            for (Account account : client.getClientAccounts()) {
                System.out.println(String.join("", "   ", account.toString()));
            }
        }
    }
}
