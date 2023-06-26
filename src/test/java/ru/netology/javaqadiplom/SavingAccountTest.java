package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
    @Test
    public void shouldPayLessBalanceIsMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(true, account.pay(1_000));
        Assertions.assertEquals(2_000 - 1_000, account.getBalance());
    }
    @Test
    public void shouldNotPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_500);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldAddBalanceIsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }
    @Test
    public void shouldNotPayBalanceIsNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldNotPayMimBalanceIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }
    @Test
    public void shouldYearChange() { // Проверка расчета суммы процентов при положэительном балансе
        SavingAccount account = new SavingAccount(
                350,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(52,  account.yearChange());
    }
    @Test
    public void shouldYearChangeBalanceIsNegative() { // Проверка расчета суммы процентов при отрицательном балансе
        SavingAccount account = new SavingAccount(
                -200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(0,  account.yearChange());
    }
}
