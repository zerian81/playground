package net.dagar.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static List<Integer> getPrimeFactors(int i) {

        if (i <= 0) {
            throw new IllegalArgumentException("Positive numbers only!");
        }

        List<Integer> primes = new ArrayList<>();

        for (int primeFactor = 2; primeFactor <= Math.ceil(Math.sqrt(i)); primeFactor++) {
            while (i % primeFactor == 0) {
                primes.add(primeFactor);
                i /= primeFactor;
            }
        }

        if (i > 1) {
            primes.add(i);
        }

        return primes;
    }
}
