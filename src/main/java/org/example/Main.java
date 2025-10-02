package org.example;




public class Main {
    public static void main(String[] args) {
        BankAccount test = new BankAccount("Серега");
        BankAccount test2 = new BankAccount("Петр");
        System.out.println("Тест пополнения на 100:" + test.Deposit(100));
        System.out.println("Тест снятия 50:" + test.Withdraw(50));
        System.out.println("Тест перевода 50:" + test.Transfer(test2,50));
        System.out.println("Первый:" + test + " Второй:" + test2);
    }
}