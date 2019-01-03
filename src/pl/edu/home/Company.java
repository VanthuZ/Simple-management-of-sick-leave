package pl.edu.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private List<String> departmentList;

    public Company() {
        System.out.println("Wprowadź nazwę firmy");
        this.name = scanner.nextLine();

        System.out.println("Czy chcesz utworzyć odział dla tej firmy?  T/N");
        if(scanner.next().toLowerCase().charAt(0) == 't'){
           departmentList = new ArrayList<>();
           System.out.println("Podaj nazwę odziału");
           departmentList.add(scanner.nextLine());
        }
    }

    public void addNewDepartment(){
        System.out.println("Podaj nazwę odziału");
        departmentList.add(scanner.nextLine());
    }

    public void deleteDepartment(){
        System.out.println("***Lista obecnych odziałów firmy***");
        for(int i = 0; i < departmentList.size(); i++){
            System.out.println(i + " " + departmentList.indexOf(i));
        }
        System.out.println("Podaj numer odziały, który ma zostać usunięty");
        departmentList.remove(scanner.nextInt());
    }
}
