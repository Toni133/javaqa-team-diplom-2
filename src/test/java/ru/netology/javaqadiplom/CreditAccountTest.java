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
    public void checkingTheExclusionInCaseOfANegativeCreditLimit() { // проверка выкидывания исключения при отрицальном кредитном лимите
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(500, -1_000, 15);
        });
    }

    @Test
    public void exceedingTheCreditLimit() { // проверка оплаты с превышением кредитного лимита
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(6_000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void accrualOfInterestOnAPositiveBalance() { // проверка начисления процентов на положительный баланс
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void reducingTheFractionalPartToAnInteger() { // проверка начисления процентов на отрицательный баланс
        CreditAccount account = new CreditAccount(
                -350,
                5_000,
                15
        );

        Assertions.assertEquals(-52, account.yearChange());
    }

    @Test
    public void toppingUpAnAccountWithANegativeBalance() { // проверка пополнения при отрицательнолм балансе
        CreditAccount account = new CreditAccount(
                -1500,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(1500, account.getBalance());
    }

}
