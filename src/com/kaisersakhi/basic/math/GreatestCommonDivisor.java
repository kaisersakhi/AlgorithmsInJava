package com.kaisersakhi.basic.math;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
//        System.out.println(new GreatestCommonDivisor().slothGCD(8, 12));
        System.out.println(new GreatestCommonDivisor().euclidGCD(8, 12));
    }

    int slothGCD(int x, int y){
        for (int i = ((x < y) ? x -1 : y -1); i > 0; --i){
            if (y % i == 0 && x % i == 0) return i;
        }
        return 0;
    }

    int euclidGCD(int m, int n){
        if (m <= 0 || n <= 0) return -1;
        int r;
        while (true){
            r = m % n;
            if (r == 0) return  n;
            m = n;
            n = r;
        }

    }
}
