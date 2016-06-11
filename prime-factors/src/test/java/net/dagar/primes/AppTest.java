package net.dagar.primes;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test(expected = IllegalArgumentException.class)
    public void testThatNegativeInputsThrowExceptions () {
        App.getPrimeFactors(-1);
    }

    @Test
    public void testPrimeFactorizationFor1() {
        assertThat(App.getPrimeFactors(1), is(empty()));
    }

    @Test
    public void testPrimeFactorizationFor2() {
        assertThat(App.getPrimeFactors(2), contains(2));
    }

    @Test
    public void testPrimeFactorizationFor3() {
        assertThat(App.getPrimeFactors(3), contains(3));
    }

    @Test
    public void testPrimeFactorizationFor4() {
        assertThat(App.getPrimeFactors(4), contains(2,2));
    }

    @Test
    public void testPrimeFactorizationFor5() {
        assertThat(App.getPrimeFactors(5), contains(5));
    }

    @Test
    public void testPrimeFactorizationFor6() {
        assertThat(App.getPrimeFactors(6), contains(2,3));
    }

    @Test
    public void testPrimeFactorizationFor7() {
        assertThat(App.getPrimeFactors(7), contains(7));
    }

    @Test
    public void testPrimeFactorizationFor8() {
        assertThat(App.getPrimeFactors(8), contains(2,2,2));
    }

    @Test
    public void testPrimeFactorizationFor9() {
        assertThat(App.getPrimeFactors(9), contains(3,3));
    }

    @Test
    public void testPrimeFactorizationFor10() {
        assertThat(App.getPrimeFactors(10), contains(2, 5));
    }

    @Test
    public void testPrimeFactorizationFor11() {
        assertThat(App.getPrimeFactors(11), contains(11));
    }

    @Test
    public void testPrimeFactorizationForSomeReallyBigNumber() {
        assertThat(App.getPrimeFactors(2*3*5*7*11*13), contains(2,3,5,7,11,13));
    }
}
