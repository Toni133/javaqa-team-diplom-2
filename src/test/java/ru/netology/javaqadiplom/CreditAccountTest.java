package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() { // проверка пополнения - положительный баланс
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void toppingUpAnAccountWithANegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1500,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    public void exceedingTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test

    public void purchaseUpToTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(5_000);
        Assertions.assertEquals(-5000, account.getBalance());
    }

    @Test
    public void ShpuldNotAddAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void accrualOfInterestOnAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void reducingTheFractionalPartToAnInteger() {
        CreditAccount account = new CreditAccount(
                -350,
                5_000,
                15
        );

        Assertions.assertEquals(-52, account.yearChange());
    }

    @Test
    public void AccrualOfInterestOnANegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }


    @Test
    public void checkingTheExclusionInCaseOfANegativeCreditLimit() { // проверка выкидывания исключения при отрицальном кредитном лимите
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5_000,
                    15);
        });
    }

    @Test
    public void ShouldNotDoIfRateIsNegative() { // проверка выкидывания исключения при отрицальном ставке
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -15);
        });
    }

    @Test
    public void ShouldNotDoIfBalanceMoreThenCreditLimit() { // проверка выкидывания исключения при превышении кредитного лимита
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -6_000,
                    5_000,
                    15);
        });
    }

    @Test
    public void shouldGetMaxBalance() { // Проверка получения кредитного лимита
        CreditAccount account = new CreditAccount(
                -4_000,
                5_000,
                15);

        Assertions.assertEquals(5_000, account.getCreditLimit());
    }

    @Test
    public void ShpuldNotPayAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void ShpuldNotAddAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }
