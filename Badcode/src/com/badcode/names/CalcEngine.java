package com.badcode.names;

import java.util.Random;

public class CalcEngine {

    StartCalculator cl;
    CalcEngine e;
    Random r = new Random();
    int MAX1 = 200;
    int MAX2 = 300;
    int MAXOPS = 10;

    public static void main(String[] args) {
        System.out.println("Starting calculator engine");
        CalcEngine e = new CalcEngine();
        e.runCalcEngineFiftyTimes();
    }

    public void runCalcEngineFiftyTimes() {
        cl = new StartCalculator();
        for (int i = 0; i < 50; i++) {
            double result = cl.calc(number1(), number2(), operation());
            System.out.println(result);
        }
    }

    public int number1() {
        int mynumber = r.nextInt(MAX1);
        System.out.println("Genrating first random number " + mynumber);
        return mynumber;
    }

    public int number2() {
        int mynumber = r.nextInt(MAX2);
        System.out.println("Genrating second random number " + mynumber);
        return mynumber;
    }

    public int operation() {
        int myoperation = r.nextInt(MAXOPS);
        while (!cl.getSupport(myoperation)) {
            myoperation = r.nextInt(MAXOPS);
            System.out.println("Got operation " + myoperation);
        }
        System.out.println("Operation " + cl.opName(myoperation));
        return myoperation;
   }


}
