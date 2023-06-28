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
    public void shouldNotPayMimBalanceIsNegative() { // Проверка выкидывания исключения при отрицательном минимальном балансе
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
    public void shouldNotPayMimBalanceMoreThenMaxBalance() { //Проверка выкидывания исключения, если минимельный баланс больше максимального
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    4_500,
                    5_000,
                    4_000,
                    5
            );
        });
    }

    @Test
    public void shouldNotPayBalanceIsZero() { //Проверка оплаты с карты - итоговый балагнс равен 0
        SavingAccount account = new SavingAccount(
                4_500,
                0,
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
    public void shouldNotDoMimBalanceIsNegative() { // Проверка исключения на отрицательнынй минимальный баланс

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
    public void shouldNotAddMimBalanceMoreThenMaxBalance() { // Проверка пополнения карты - минимальный баланс больше максимального
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    4_500,
                    5_000,
                    4_000,
                    5
            );
        });
    }

    @Test
    public void shouldYearChange() { // Проверка расчета суммы процентов при положительном балансе
        SavingAccount account = new SavingAccount(
                350,
                100,
                10_000,
                15
        );

        Assertions.assertEquals(52, account.yearChange());
    }

    @Test
    public void shouldYearChangeBalanceIsZero() { // Проверка расчета суммы процентов при нулевом балансе
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldNotDoIfRateIsNegative() { //Проверка выкидывания исключения, если ставка отрицательная
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    4_500,
                    3_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void shouldNotDoIfMinBalanceMoreThenMaxBalanc() { //Проверка выкидывания исключения, если минимальнрый баланс больше максимального
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    6_000,
                    5_000,
                    3_000,
                    5
            );
        });
    }

    @Test
    public void shouldGetMaxBalance() { // Проверка получения максимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void shouldGetMinBalance() { // Проверка получения минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );
        Assertions.assertEquals(1_000, account.getMinBalance());
    }
}