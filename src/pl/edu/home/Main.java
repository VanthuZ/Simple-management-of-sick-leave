package pl.edu.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Company> companyList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int MainChoice;
        int RaportChoice;
        int AllEmployeeRaportChoice;

        System.out.println("***Zarządzanie zwolnieniami chorobowymi");
        while(true){
            System.out.println("***Menu***");
            System.out.println("1. Dodaj firmę");
            System.out.println("2. Dodaj odział do istniejącej firmy");
            System.out.println("3. Dodaj nowego pracownika");
            System.out.println("4. Zmień status pracownika na zwolniony");
            System.out.println("5. Wprowadź zwolnienie lekarskie dla pracownika");
            System.out.println("6. Raporty");

            MainChoice = Integer.parseInt(scanner.nextLine());
            switch(MainChoice){

                case 1:{
                    companyList.add(new Company());
                    break;
                }

                case 2:{
                    System.out.println("Podaj nazwę firmy dla, której chcessz wprowadzić odział");
                    String tempName = scanner.nextLine();
                    for(Company company : companyList){
                        if(company.getName().equals(tempName)){
                            company.addNewDepartment();
                        }else{
                            //TODO check this else
                            System.out.println("W sytemie nie ma firmy o podanej nazwie " + tempName);
                        }
                    }
                    break;
                }

                case 3:{
                    personList.add(new Person(companyList));
                    break;
                }

                case 4: {
                    System.out.println("Podaj nazwisko pracownika");
                    String tempLastName = scanner.nextLine();
                    for (Person person : personList) {
                        if (person.getLastName().equals(tempLastName)) {
                            person.releaseEmployee();
                        }
                    }
                    break;
                }

                case 5:{
                    System.out.println("Podaj nazwisko pracownika");
                    String tempLastName = scanner.nextLine();
                    for(Person person : personList){
                        if(person.getLastName().equals(tempLastName)){
                            person.addSickLeave();
                        }else{
                            //TODO check this else
                            System.out.println("W systemie nie ma pracownika o takim nazwisku");
                        }
                    }
                    break;
                }

                case 6:{
                    System.out.println("***Wybierz typ raportów");
                    System.out.println("1. Raporty dla indywidualnego pracownika");
                    System.out.println("2. Raporty dla wszystkich pracowników");
                    RaportChoice = Integer.parseInt(scanner.nextLine());

                    if(RaportChoice == 1){
                        System.out.println("***Raporty dla indywidualnego pracownika");
                        System.out.println("Podaj nazwisko pracownika");
                        String tempLastName = scanner.nextLine();

                        for(Person person : personList){
                            if(person.getLastName().equals(tempLastName)){
                                person.showSickLeave();
                            }
                        }


                    }else if(RaportChoice == 2){
                        System.out.println("***Raporty dla wszystkich pracowników***");
                        System.out.println("1. Wszystkie zwolnienie lekarskie");
                        System.out.println("2. Łączna ilości dni na zwolnieniu lekarskim");
                        System.out.println("3. Lista pracowników za których płaci urząd");

                        AllEmployeeRaportChoice = Integer.parseInt(scanner.nextLine());
                        switch (AllEmployeeRaportChoice){

                            case 1:{
                                for(Person person : personList){
                                    person.showSickLeave();
                                    break;
                                }
                            }

                            case 2:{
                                for(Person person : personList){
                                    person.showNumbersOfDaysOnSickkLeave();
                                }
                                break;
                            }

                            case 3:{
                                for(Person person : personList){
                                    person.showEmployeeWherePaysOffice();
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
