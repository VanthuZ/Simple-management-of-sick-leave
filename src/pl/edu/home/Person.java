package pl.edu.home;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Person {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String lastName;
    private Company company;
    private String periodOfEmployment;
    private String employmentState; //zatrudniony czy zwolniony
    private char employeeOrStudent; //P - pracownik, U - uczen
    private String dayOfRealease;
    private Map<String,Integer> sickLeaveDateAndDays = new HashMap<>();
    private String whoPayForSickLeave;

    //basic constructor for manual input
    public Person(Company selectedCompany) {
        System.out.println("Wprowadź imię");
        this.name = scanner.nextLine();
        System.out.println("Wprowadź nazwisko");
        this.lastName = scanner.nextLine();
        company = new Company(selectedCompany.getName());
        if(selectedCompany.getDepartmentList().size() == 0){
            this.company.setDepartment("-");
        }else{
            System.out.println("Do jakiego odziału należy pracownik");
            for(int i = 1; i <= selectedCompany.getDepartmentList().size(); i++){
                System.out.println("Nr: " + i + " " + selectedCompany.getDepartmentList().get(i-1));
            }
            this.company.setDepartment(selectedCompany.getDepartmentList().get(Integer.parseInt(scanner.nextLine())-1));
        }

        System.out.println("Wprowadź okres umowy");
        this.periodOfEmployment = scanner.nextLine();
        this.employmentState = "Zatrudniony";
        System.out.println("Wprowadź status. Pracownik(P) czy Uczeń(U)");
        this.employeeOrStudent = scanner.nextLine().charAt(0);
        this.whoPayForSickLeave = "Pracodawca";

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

    public int numberOfDaysOnSickLeave(){
        int numberOfDays = 0;
        for(Map.Entry<String, Integer> entry : this.sickLeaveDateAndDays.entrySet()){
            numberOfDays += entry.getValue();
        }
        return numberOfDays;
    }

    public void showNumbersOfDaysOnSickkLeave(){
        int numberOfDays = 0;
        for(Map.Entry<String, Integer> entry : this.sickLeaveDateAndDays.entrySet()){
            numberOfDays += entry.getValue();
        }
        System.out.println(this.name + " " + this.lastName + " łączna ilość dni na zwolnieniu " + numberOfDays);
    }

    public void showEmployeeWherePaysOffice(){
        int numberOfDays = 0;
        for(Map.Entry<String, Integer> entry : this.sickLeaveDateAndDays.entrySet()){
            numberOfDays += entry.getValue();
        }
        if(numberOfDays >= 33){
            System.out.println(this.name + " " + this.lastName + " łączna ilość dni na zwolnieniu " + numberOfDays);
        }
    }

    public void showBasicInformation(){
        System.out.println(name + " " + lastName + " Firma: " + company.getName() + " Odział: " + company.getDepartment() + "\n"
                + "Czas umowy " + periodOfEmployment + " Status: " + employeeOrStudent + " Status: " + employmentState
                + "\nŁączna ilość dni na zwolnieniu " + numberOfDaysOnSickLeave());

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Company getCompany() {
        return company;
    }


}

