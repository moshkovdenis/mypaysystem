package ru.denismoshkov.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private int accountNumber;
    private int sum;
    private Person client;
    Boolean isBlocked;

    @Override
    public String toString() {
        return String.join(" | ", String.valueOf(accountNumber), String.valueOf(sum));
    }
}
