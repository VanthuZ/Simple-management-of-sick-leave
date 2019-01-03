package pl.edu.home;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        System.out.println("******************dodawanie pracownika********");
        personList.add(new Person());
        System.out.println("******************dodawanie zwolnienia********");
        personList.get(0).addSickLeave();
        System.out.println("******************dodawanie 2 zwolnienia********");
        personList.get(0).addSickLeave();
        System.out.println("******************pokazanie zwolnienia********");
        personList.get(0).showSickLeave();
        personList.get(0).showNumbersOfDaysOnSickkLeaveForOneEmployee();


    }
}
