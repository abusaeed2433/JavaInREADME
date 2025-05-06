package interfaces.part2;

import java.time.LocalDate;

public class MyAccount implements ATM, ATM.Card{
    @Override
    public boolean login(int account) {
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public String getNumber() {
        return null;
    }

    @Override
    public String getSecurityCode() {
        return null;
    }

    @Override
    public LocalDate getExpirationDate() {
        return null;
    }

    @Override
    public String getCardHolderName() {
        return null;
    }
}
