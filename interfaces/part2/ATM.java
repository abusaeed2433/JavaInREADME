package interfaces.part2;

import java.time.LocalDate;

public interface ATM {

    boolean login(int account);
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();

    interface Card {
        String getNumber();
        String getSecurityCode();
        LocalDate getExpirationDate();
        String getCardHolderName();
    }

}
