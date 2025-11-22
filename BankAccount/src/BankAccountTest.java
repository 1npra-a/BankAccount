import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void testvalidInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testNegativeInitialBalance() {
        assertThrows(AssertionError.class, () -> new BankAccount(-50.0));
    }

    @Test
    void testDepositAmount() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testDepositZeroOrNegative() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(AssertionError.class, () -> account.deposit(0.0));
        assertThrows(AssertionError.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawTooMuch() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(AssertionError.class, () -> account.withdraw(200.0));
    }

    @Test
    void testGetBalanceAfterOperations() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        account.withdraw(30.0);
        assertEquals(120.0, account.getBalance(), 0.001);
    }
}
