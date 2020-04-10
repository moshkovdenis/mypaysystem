package ru.denismoshkov.processors;

import lombok.extern.slf4j.Slf4j;
import ru.denismoshkov.beans.Account;
import ru.denismoshkov.exeptions.ReplenishException;

@Slf4j
public class AccountProcessor {

    public static void replenishAccount(Account account, int replenishSum) throws ReplenishException {
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()),
                "на сумму", String.valueOf(replenishSum)));
        if (replenishSum <= 0) {
            log.error("Ошибка при пополнении - сумма пополнения меньше 0");
            throw new ReplenishException("Сумма пополнения счета меньше 0.");
        }
        account.setSum(account.getSum() + replenishSum);
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()),
                "прошло успешно. Текущая сумма на счете ", String.valueOf(account.getSum())));
    }

    public static void writeOffAccount(Account account, int writeOffSum) {

    }

    public static void transferMoney(Account fromAccount, Account toAccount, int sum) {

    }
}
