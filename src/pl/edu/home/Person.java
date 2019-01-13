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
    private String whoPayForSickLeave;
    private Map<String,Integer> sickLeaveDateAndDays = new HashMap<>();


    //contructor for read from database with sickLeaveDays
    public Person(String name, String lastName, Company company, String periodOfEmployment, String employmentState,
                  char employeeOrStudent, String dayOfRealease, Map<String, Integer> sickLeaveDateAndDays) {
        this.name = name;
        this.lastName = lastName;
        this.company = company;
        this.periodOfEmployment = periodOfEmployment;
        this.employmentState = employmentState;
        this.employeeOrStudent = employeeOrStudent;
        this.dayOfRealease = dayOfRealease;
        this.sickLeaveDateAndDays = sickLeaveDateAndDays;
    }

    //contructor for read from database without sickLeaveDays
    public Person(String name, String lastName, Company company, String periodOfEmployment, String employmentState,
                  char employeeOrStudent, String dayOfRealease) {
        this.name = name;
        this.lastName = lastName;
        this.company = company;
        this.periodOfEmployment = periodOfEmployment;
        this.employmentState = employmentState;
        this.employeeOrStudent = employeeOrStudent;
        this.dayOfRealease = dayOfRealease;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPeriodOfEmployment() {
        return periodOfEmployment;
    }

    public void setPeriodOfEmployment(String periodOfEmployment) {
        this.periodOfEmployment = periodOfEmployment;
    }

    public String getEmploymentState() {
        return employmentState;
    }

    public void setEmploymentState(String employmentState) {
        this.employmentState = employmentState;
    }

    public char getEmployeeOrStudent() {
        return employeeOrStudent;
    }

    public void setEmployeeOrStudent(char employeeOrStudent) {
        this.employeeOrStudent = employeeOrStudent;
    }

    public String getDayOfRealease() {
        return dayOfRealease;
    }

    public void setDayOfRealease(String dayOfRealease) {
        this.dayOfRealease = dayOfRealease;
    }

    public Map<String, Integer> getSickLeaveDateAndDays() {
        return sickLeaveDateAndDays;
    }

    public void setSickLeaveDateAndDays(Map<String, Integer> sickLeaveDateAndDays) {
        this.sickLeaveDateAndDays = sickLeaveDateAndDays;
    }

    public String getWhoPayForSickLeave() {
        return whoPayForSickLeave;
    }

    public void setWhoPayForSickLeave(String whoPayForSickLeave) {
        this.whoPayForSickLeave = whoPayForSickLeave;
    }
}

