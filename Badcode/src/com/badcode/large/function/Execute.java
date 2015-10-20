package com.badcode.large.function;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapil on 20/10/15.
 */
public class Execute {

    public static void main(String[] args) throws IOException {

        // read csv file 1
        BufferedReader reader1 = new BufferedReader(new FileReader("resources//data1.csv"));

        String line = reader1.readLine();

        StringBuffer sb1 = new StringBuffer();

        List<Double> list1 = new ArrayList<Double>();
        while (line != null) {
            // Print read line
//            System.out.println(line);

            double number1 = Double.valueOf(line.substring(0, line.indexOf(",")));
            double number2 = Double.valueOf(line.substring(line.indexOf(",") + 1, line.lastIndexOf(",")));
            double result = 0;
            String operation = line.substring(line.lastIndexOf(",") + 1, line.length());

            if (operation.equalsIgnoreCase("add")) {
                result = number1 + number2;
                sb1.append(result).append("\n");
                list1.add(result);
            } else if (operation.equalsIgnoreCase("subtract")) {
                result = number1 - number2;
                sb1.append(result).append("\n");
                list1.add(result);
            } else if (operation.equalsIgnoreCase("multiply")) {
                result = number1 * number2;
                sb1.append(result).append("\n");
                list1.add(result);
            } else if (operation.equalsIgnoreCase("divide")) {
                result = number1 / number2;
                sb1.append(result).append("\n");
                list1.add(result);
            }

            // Read next line for while condition
            line = reader1.readLine();
        }

        reader1.close();

        // write result file 1
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("resources//result1.txt"));
        writer1.write(sb1.toString());
        writer1.close();


        // Process Second File

        // read csv file 2
        BufferedReader reader2 = new BufferedReader(new FileReader("resources//data2.csv"));

        String line2 = reader2.readLine();

        StringBuffer sb2 = new StringBuffer();

        List<Double> list2 = new ArrayList<Double>();

        while (line2 != null) {
            double number1 = Double.valueOf(line2.substring(0, line2.indexOf(",")));
            double number2 = Double.valueOf(line2.substring(line2.indexOf(",") + 1, line2.lastIndexOf(",")));
            double result = 0;
            String operation = line2.substring(line2.lastIndexOf(",") + 1, line2.length());

            if (operation.equalsIgnoreCase("add")) {
                result = number1 + number2;
                sb2.append(result).append("\n");
                list2.add(result);
            } else if (operation.equalsIgnoreCase("subtract")) {
                result = number1 - number2;
                sb2.append(result).append("\n");
                list2.add(result);
            } else if (operation.equalsIgnoreCase("multiply")) {
                result = number1 * number2;
                sb2.append(result).append("\n");
                list2.add(result);
            } else if (operation.equalsIgnoreCase("divide")) {
                result = number1 / number2;
                sb2.append(result).append("\n");
                list2.add(result);
            }

            // Read next line for while condition
            line2 = reader2.readLine();
        }

        reader2.close();

        // result file 2
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("resources//result2.txt"));
        writer2.write(sb2.toString());
        writer2.close();


        // Now write the merged file by adding both result list elements
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("resources//merged-result.txt"));
        StringBuffer sbMerged = new StringBuffer();

        for (int i = 0; i < list1.size(); i++) {
            sbMerged.append(list1.get(i) + list2.get(i)).append("\n");
        }
        writer3.write(sbMerged.toString());
        writer3.close();

    }
}
