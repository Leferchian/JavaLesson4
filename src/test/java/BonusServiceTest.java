import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();


        boolean registered = true;
        long amount = 1000;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();


        boolean registered = true;
        long amount = 1_000_000;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateRegisteredAndOneLessLimit() {
        BonusService service = new BonusService();


        boolean registered = true;
        long amount = 16639;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateRegisteredAndEqalLimit() {
        BonusService service = new BonusService();


        boolean registered = true;
        long amount = 16667;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateRegisteredAndOneMoreLimit() {
        BonusService service = new BonusService();


        boolean registered = true;
        long amount = 16766;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();


        boolean registered = false;
        long amount = 50100;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndEqalLimit() {
        BonusService service = new BonusService();


        boolean registered = false;
        long amount = 50000;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndOneLessLimit() {
        BonusService service = new BonusService();


        boolean registered = false;
        long amount = 49900;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndNoBonus() {
        BonusService service = new BonusService();


        boolean registered = false;
        long amount = 50;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndOneBonus() {
        BonusService service = new BonusService();


        boolean registered = false;
        long amount = 199;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);

    }
}