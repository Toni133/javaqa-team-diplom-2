package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreditAccountTest {

    @Test

    public void shouldAddToPositiveBalance() {
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
    public void checkingTheExclusionInCaseOfANegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                -5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        });
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
    public void purchaseOnCredit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3_000, account.getBalance());
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
    public void checkingTheExclusionInCaseOfANegativeCreditLimi() { // проверка выкидывания исключения при отрицальном кредитном лимите
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    500,
                    -1_000,
                    15);
        });
    }
}
