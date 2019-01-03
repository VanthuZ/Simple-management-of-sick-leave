package pl.edu.home;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String lastName;
    private Company company;
    private String periodOfEmployment;
    private String employmentState; //zatrudniony czy zwolniony
    private char employeeOrStudent; //P - pracownik, U - uczen
    private String dayOfRealease;
    private Map<String,Integer> sickLeaveDateAndDays = new HashMap<>();

    //basic constructor for manual input
    public Person() {
        System.out.println("Wprowadź imię");
        this.name = scanner.nextLine();
        System.out.println("Wprowadź nazwisko");
        this.lastName = scanner.nextLine();
        System.out.println("Wprowadź okres umowy");
        this.periodOfEmployment = scanner.nextLine();
        this.employmentState = "Zatrudniony";
        System.out.println("Wprowadź status. Pracownik(P) czy Uczeń(U)");
        this.employeeOrStudent = scanner.nextLine().charAt(0);
    }

    public void releaseEmployee(){
        System.out.println("Wprowadź datę zwolnienia");
        dayOfRealease = scanner.nextLine();
        employmentState = "Zwolniony";
    }

    public void addSickLeave(){
        System.out.println("Wprowadź datę zwolnienia lekarskiego");
        String tempDate = scanner.nextLine();
        System.out.println("Wprowadź ilość dni na zwolnieniu");
        int tempDays = Integer.parseInt(scanner.nextLine());
        sickLeaveDateAndDays.put(tempDate, tempDays);
    }

    public void showSickLeave(){
        System.out.println(this.name + " " + this.lastName);
        for(Map.Entry<String, Integer> entry : sickLeaveDateAndDays.entrySet()){
            System.out.println("Okres: " + entry.getKey() + " dni na zwolnieniu: " + entry.getValue());
        }
    }

    public void showNumbersOfDaysOnSickkLeaveForOneEmployee(){
        int numberOfDays = 0;
        for(Map.Entry<String, Integer> entry : this.sickLeaveDateAndDays.entrySet()){
            numberOfDays += entry.getValue();
        }
        System.out.println(this.name + " " + this.lastName + " łączna ilość dni na zwolnieniu " + numberOfDays);

    }

}

