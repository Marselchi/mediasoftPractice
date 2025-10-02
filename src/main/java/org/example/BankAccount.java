package org.example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    String owner;
    int balance; //Странно что целое но ок
    LocalDateTime openDate;
    boolean isBlocked;
    String number;

    BankAccount(String owner){
        this.owner = owner;
        balance = 0;
        openDate = LocalDateTime.now();
        isBlocked = false;
        Random rand = new Random();
        this.number = String.format("%08d", rand.nextInt(100_000_000)); //Технически под тз подходит)
    }

    public boolean Deposit(int amount) {
        if(amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean Withdraw(int amount) {
        if(amount <= 0 || balance - amount < 0) return false;
        balance -= amount;
        return true;
    }
    //По хорошему target бы
    public boolean Transfer(BankAccount otherAccount, int amount){
        if(Withdraw(amount)) return otherAccount.Deposit(amount);
        return false;
    }

    @Override
    public String toString() {
        return "Банковский аккаунт " +
                "Владелец:" + owner +
                ", Номер счета:" + number +
                ", Баланс:" + balance +
                ", Дата Открытия:" + openDate +
                ", Заблокирован:" + isBlocked;
    }

    //Допустим сравнение по номеру аккаунта и владельцу (хотя владелец мб может поменятся)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(owner, that.owner) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, number);
    }
}
