package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldPayMoreThanMinBalance() { // Проверка оплаты с карты при положительном балансе и корреткных начальных условиях
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(2_000 - 500, account.getBalance());
    }

    @Test
    public void shouldPayBalanceIsMinBalance() { // Проверка оплаты с карты при итоговом балансе равном минимальному
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(2_000 - 1_000, account.getBalance());
    }

    @Test
    public void shouldNotPayLessThanMinBalance() { // Проверка оплаты с карты при итоговом балансе меньше минималоьоного
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
    public void shouldNotPayAmountIsNegative() { // Проверка оплаты с карты при отрицательонй сумме оплаты
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-500);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotPayBalanceIsNegative() { // Проверка оплаты с карты при отрицательном итоговом балансе
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
    public void shouldNotPayMimBalanceIsNegative() { // Проверка оплаты с карты при отрицательном минимальном балансе
        SavingAccount account = new SavingAccount(
                2_000,
                -1_000,
                10_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.pay(400);
        });
    }

    @Test
    public void shouldNotPayMimBalanceMoreThenMaxBalance() { //Проверка оплаты с карты - минимельный баланс больше максимального
        SavingAccount account = new SavingAccount(
                4_500,
                5_000,
                4_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.pay(400);
        });
    }

    @Test
    public void shouldNotPayBalanceIsZero() { //Проверка оплаты с карты - итоговый балагнс равен 0
        SavingAccount account = new SavingAccount(
                4_500,
                5_000,
                4_000,
                5
        );
        account.pay(4_500);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMaxBalance() { // Проверка пополнения карты - итоговый баланс меньше максимального
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
    public void shouldAddBalanceIsMaxBalance() { // Проверка пополнения карты - иттоговый баланс равен максимальному
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
    public void shouldNotAddMoreThanMaxBalance() { // Проверка пополнения карты  - итоговй баланс больше максимального
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddAmountIsNegative() { // Проверка пополнения карты при отрицательной сумме оплаты
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-500);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMimBalanceIsNegative() { // Проверка пополнения карты при отрицательном минимальном балансе
        SavingAccount account = new SavingAccount(
                2_000,
                -1_000,
                10_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(400);
        });
    }

    @Test
    public void shouldNotAddMimBalanceMoreThenMaxBalance() { // Проверка пополнения карты - минимальный баланс больше максимального
        SavingAccount account = new SavingAccount(
                4_500,
                5_000,
                4_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(400);
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

        Assertions.assertEquals(52, account.yearChange());
    }

    @Test
    public void shouldYearChangeBalanceIsZero() { // Проверка расчета суммы процентов при нулевом балансе
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeBalanceIsNegative() { // Проверка расчета суммы процентов при отрицательном балансе
        SavingAccount account = new SavingAccount(
                -200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
