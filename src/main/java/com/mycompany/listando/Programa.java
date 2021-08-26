/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listando;

import java.util.ArrayList;
import java.util.List;
import entities.Prime;
import java.util.Scanner;
import entities.Employee;

/**
 *
 * @author morpha
 */
public class Programa {

    public static void main(String[] args) {
        float x;
        float y = (float) Prime.count(50);
        
        x = 50/y;
        
        System.out.println(y);
        System.out.println(x);
//        
//        for (int i=2; i<= 50; i++){
//            x = i/Prime.count(i);
//            System.out.println(x);
//        }
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many employees will be registered?");
        int n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();

        System.out.println("\n---------------------------------------\n");
        System.out.println("Enter employee data:\n");

        for (int i = 1; i <= n; i++) {
            System.out.println("id: ");
            int id = sc.nextInt();
            sc.nextLine();
            while (hasId(employeeList, id)) {
                System.out.println("id already taken.");
                System.out.println("id: ");
                id = sc.nextInt();
                sc.nextLine();
            }
            System.out.println("name: ");    // bloco de leitura dos dados
            String name = sc.nextLine();
            System.out.println("salary: ");
            double salary = sc.nextDouble();

            employeeList.add(new Employee(id, name, salary));
            System.out.println("");
        }
        System.out.println("");
        int w = 0;
        for (Employee emp : employeeList) {
            w++;
            System.out.println(w + ". " + emp);
        }

        
        
        // aumentar salário:
        System.out.println("");
        System.out.println("Enter the employee id that will have salary increase:");
        int id = sc.nextInt();
        while (hasId(employeeList, id) == false) {
            System.out.println("There is no such id.");
            System.out.println("Enter the employee id that will have salary increase:");
            id = sc.nextInt();
        }
        System.out.println("Enter increase percentage:");
        double percentage = sc.nextDouble();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.increaseSalary(percentage);
            }
        }

        //printar geral:
        System.out.println("Employees:\n");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        sc.close();
    }

    
    
    public static boolean hasId(List<Employee> list, int id) {
        int check = 0;
        for (Employee emp : list) {
            if (emp.getId() == id) {
                check += 1;
                break;
            }
        }
        return check != 0;

    }

}
