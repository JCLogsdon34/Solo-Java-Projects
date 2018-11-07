package com.mycompany.vmlou.userio;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class UserIOImpl implements UserIO {

    Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double myDouble = 0;
        String stringDouble = "";
        System.out.println(prompt);
        stringDouble = userInput.nextLine();
        myDouble = Double.parseDouble(stringDouble);
        return myDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double myDouble = 0;
        String stringDouble = "";
        System.out.println(prompt + " " + min + " " + max);
        stringDouble = userInput.nextLine();
        myDouble = Double.parseDouble(stringDouble);
        return myDouble;
    }

    @Override
    public float readFloat(String prompt) {
        float myFloat = 0;
        String floatString = "";
        System.out.println(prompt);
        floatString = userInput.nextLine();
        myFloat = Float.parseFloat(floatString);
        return myFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float myFloat = 0;
        String floatString = "";
        System.out.println(prompt + " " + min + " " + max);
        floatString = userInput.nextLine();
        myFloat = Float.parseFloat(floatString);
        return myFloat;
    }

    @Override
    public int readInt(String prompt) {
        int myInt = 0;
        String stringInt = "";
        System.out.println(prompt);
        stringInt = userInput.nextLine();
        myInt = Integer.parseInt(stringInt);
        return myInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int myInt = 0;
        String stringInt = "";
        System.out.println(prompt + " " + min + " " + max);
        stringInt = userInput.nextLine();
        myInt = Integer.parseInt(stringInt);
        return myInt;
    }

    @Override
    public long readLong(String prompt) {
        long myLong = 0;
        String longString = "";
        System.out.println(prompt);
        longString = userInput.nextLine();
        myLong = Long.parseLong(longString);
        return myLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long myLong = 0;
        String longString = "";
        System.out.println(prompt + " " + min + " " + max);
        longString = userInput.nextLine();
        myLong = Long.parseLong(longString);
        return myLong;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        String string = "";
        System.out.println(prompt);
        string = userInput.nextLine();
        BigDecimal myBigDecimal = new BigDecimal(string);
        return myBigDecimal;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        String string = "";
        System.out.println(prompt + " " + min + " " + max);
        string = userInput.nextLine();
        BigDecimal myBigDecimal = new BigDecimal(string);
        return myBigDecimal;
    }

    @Override
    public String readString(String prompt) {
        String userString;
        System.out.println(prompt);
        userString = userInput.nextLine();
        return userString;
    }
}
