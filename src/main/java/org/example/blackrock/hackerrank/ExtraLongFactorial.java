package org.example.blackrock.hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorial {

    public static BigInteger fact(BigInteger bigInteger){
        if(bigInteger.equals(0) || bigInteger.equals(1)){
            return new BigInteger(String.valueOf(1));
        }

        return bigInteger.multiply(fact(bigInteger.subtract(new BigInteger(String.valueOf(1)))));
    }

    public static void main(String[] args) {
        System.out.println(fact(new BigInteger(String.valueOf(5))));
    }
}
