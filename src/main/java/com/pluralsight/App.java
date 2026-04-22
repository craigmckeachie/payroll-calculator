package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String header = bufferedReader.readLine(); //read and ignore header row
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] fields = line.split(Pattern.quote("|"));
                Employee employee = new Employee();

                int employeeId = Integer.parseInt(fields[0]);
                employee.setEmployeeId(employeeId);

                employee.setName(fields[1]);

                double hoursWorked = Double.parseDouble(fields[2]);
                employee.setHoursWorked(hoursWorked);

                double payRate = Double.parseDouble(fields[3]);
                employee.setPayRate(payRate);

                String employeeDataAsString = employee.toString();
                System.out.println(employeeDataAsString);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The employees file could not be read.");
        }

    }
}
