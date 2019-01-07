package pl.edu.home;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    Scanner scanner2 = new Scanner(System.in);
    private String name;
    private String department;
    private ArrayList<String> departmentList = new ArrayList<>();

    public Company(String name){
        this.name = name;
    }

    public Company() {
        System.out.println("Wprowadź nazwę firmy");
        this.name = scanner2.nextLine();
        System.out.println("Czy chcesz wprowadzić nazwę odziału  T/N");
        if(scanner2.nextLine().toUpperCase().charAt(0) == 'T') {
            do {
                System.out.println("Podaj nazwę odziału");
                String tempName = scanner2.nextLine();
                departmentList.add(tempName);
                System.out.println();
                System.out.println("Czy chcesz wprowadzić kolejny odział? T/N");
            }
            while (scanner2.nextLine().toUpperCase().charAt(0) == 'T');
        }else{
            this.department = "-";
        }
    }

    public void addNewDepartment(){
        System.out.println("Podaj nazwę odziału");
        departmentList.add(scanner2.nextLine());
    }

    public void deleteDepartment(){
        System.out.println("***Lista obecnych odziałów firmy***");
        for(int i = 0; i < departmentList.size(); i++){
            System.out.println(i + " " + departmentList.indexOf(i));
        }
        System.out.println("Podaj numer odziały, który ma zostać usunięty");
        departmentList.remove(scanner2.nextInt());
    }


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<String> getDepartmentList() {
        return departmentList;
    }
}
