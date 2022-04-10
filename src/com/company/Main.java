package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Scalar s1 = new Integer(-30);
        Scalar s2 = new Integer(5);

        System.out.println(s1.add(s2));
    }
}
