package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();

    /**
     * TODO 2. Переработать методо generateEmployee(). Метод должен возвращать
     * любого случайного сотрудника разного типа (Worker, Freelancer).
     * @return
     */
    public static Worker generateEmployee(){
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

        int salary = random.nextInt(900, 1500);
        int salaryIndex = random.nextInt(28, 31);
        return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], salary*salaryIndex);
    }


    public static void main(String[] args) {

//        Worker worker = new Worker("Глеб", "Григорьев", 120000);
//        System.out.println(worker);

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        for (Employee employee: employees) {
            System.out.println(employee);
        }

//        Arrays.sort(employees, new SalaryComparator());
//        Arrays.sort(employees, new SurNameComparator());
        Arrays.sort(employees);

        System.out.println("\n*** Отсортированный массив сотрудников ***\n");

        for (Employee employee: employees) {
            System.out.println(employee);
        }

//        int a = 2;
//        boolean f = true;
//        String str = "Hello!";
//
//        System.out.println(worker);
//        System.out.println(a);
//        System.out.println(f);
//        System.out.println(str);
    }
}

/**
 * TODO 3. Создать свой дополнительный компаратор, можно добавить дополнительные состояния
 * по которым будет производится сравнение.
 */
class SalaryComparator implements Comparator<Employee>{

    // 1 0 -1

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
//        return o1.calculateSalary() == o2.calculateSalary() ? 0 :
//                (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
    }
}

class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.surName.compareTo(o2.surName);
    }
}

abstract class Employee implements Comparable<Employee>{

    protected String firstName;
    protected String surName;
    protected double salary;

    public Employee(String firstName, String surName, double salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Ставка: %.2f; Среднемесячна заработная плата: %.2f",
                surName, firstName, salary, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(String firstName, String surName, double salary) {
        super(firstName, surName, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячна заработная плата: %.2f",
                surName, firstName, salary, calculateSalary());
    }

}


/**
 * TODO: 1. Разработать самостоятельно в рамках домашней работы.
 */
class Freelancer{
    // salary * 18 * 5
}
