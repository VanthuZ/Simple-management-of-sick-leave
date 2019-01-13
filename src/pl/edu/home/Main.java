package pl.edu.home;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SaveFile saveData = new SaveFile();
        Reader readData = new Reader();
        List<Company> companyList = readData.readCompany();
        List<Person> personList = readData.readPerson(companyList);

        Scanner scanner = new Scanner(System.in);
        int MainChoice;
        int choice = 0;
        int RaportChoice;
        int AllEmployeeRaportChoice;
        Company selectedCompany = null;

        System.out.println("***Zarządzanie zwolnieniami chorobowymi***");
        while (true) {

            System.out.println("1. Wybór firmy na której chcesz pracować");
            System.out.println("2. Wyświetl listę dostępnych firm");
            System.out.println("3. Dodaj nową firmę");
            System.out.println("4. Zamknięcie programu");
            try {
                MainChoice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                continue;
            }

            switch (MainChoice) {

                case 1: {
                    for (int i = 1; i <= companyList.size(); i++) {
                        System.out.println("Nr. " + i + " " + companyList.get(i - 1).getName());
                    }
                    System.out.println("Podaj numer firmy");
                    try {
                        int tempNumber = Integer.parseInt(scanner.nextLine());
                        selectedCompany = companyList.get(tempNumber - 1);
                    }catch (NumberFormatException e){
                        System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                        continue;
                    }


                    if (selectedCompany == null) {
                        System.out.println("Błędny numer");
                        continue;
                    }
                    break;
                }

                case 2: {
                    for (int i = 1; i <= companyList.size(); i++) {
                        System.out.println("Nr. " + i + " " + companyList.get(i - 1).getName());
                    }
                    continue;
                }

                case 3: {
                    companyList.add(new Company());
                    continue;
                }

                case 4: {
                    saveData.savePerson(personList);
                    saveData.saveCompany(companyList);
                    return;
                }
            }

            do {

                System.out.println("***Menu***");
                System.out.println("1. Dodaj nowego pracownika");
                System.out.println("2. Zmień status pracownika na zwolniony");
                System.out.println("3. Wprowadź zwolnienie lekarskie dla pracownika");
                System.out.println("4. Raporty");
                System.out.println("5. Wyjście do głównego menu");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                    continue;
                }

                switch (choice) {
                    case 1: {
                        personList.add(new Person(selectedCompany));
                        continue;
                    }

                    case 2: {
                        System.out.println("Podaj numer pracownika");
                        for (int i = 1; i <= personList.size(); i++) {
                            System.out.println("Nr. " + i + personList.get(i - 1).getName() + personList.get(i - 1).getLastName());
                        }
                        try {
                            int tempNumber = Integer.parseInt(scanner.nextLine());
                            personList.get(tempNumber - 1).releaseEmployee();
                        } catch (NumberFormatException e) {
                            System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                            continue;
                        }
                        continue;
                    }

                    case 3: {
                        for (int i = 1; i <= personList.size(); i++) {
                            if (personList.get(i - 1).getCompany().getName().equals(selectedCompany.getName())) {
                                System.out.println("Nr. " + i + " " + personList.get(i - 1).getName() + " " + personList.get(i - 1).getLastName());
                            }
                        }
                        System.out.println("Podaj numer pracownika");
                        try {
                            int tempNumber = Integer.parseInt(scanner.nextLine());
                            personList.get(tempNumber - 1).addSickLeave();
                        }catch(NumberFormatException e) {
                            System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                            continue;
                        }
                        continue;
                    }

                    case 4: {
                        System.out.println("***Wybierz typ raportów");
                        System.out.println("1. Raporty dla indywidualnego pracownika");
                        System.out.println("2. Raporty dla wszystkich pracowników");

                        try {
                            RaportChoice = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                            continue;
                        }

                        if (RaportChoice == 1) {
                            System.out.println("***Raporty dla indywidualnego pracownika");

                            for (int i = 1; i <= personList.size(); i++) {
                                if (personList.get(i - 1).getCompany().getName().equals(selectedCompany.getName())) {
                                    System.out.println("Nr. " + i + " " + personList.get(i - 1).getName() + " " + personList.get(i - 1).getLastName());
                                }
                            }
                            System.out.println("Podaj numer pracownika");
                            try {
                                int tempNumber = Integer.parseInt(scanner.nextLine());
                                personList.get(tempNumber - 1).showSickLeave();
                            }catch(NumberFormatException e) {
                                System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                                continue;
                            }


                        } else if (RaportChoice == 2) {
                            System.out.println("***Raporty dla wszystkich pracowników***");
                            System.out.println("1. Wszystkie zwolnienie lekarskie");
                            System.out.println("2. Łączna ilości dni na zwolnieniu lekarskim");
                            System.out.println("3. Lista pracowników za których płaci urząd");
                            System.out.println("4. Informacje o pracownikach");

                            try {
                                AllEmployeeRaportChoice = Integer.parseInt(scanner.nextLine());
                            }catch (NumberFormatException e){
                                System.out.println("\nZły format danych wejściowych lub pusty ciąg znaków\n");
                                continue;
                            }

                            switch (AllEmployeeRaportChoice) {

                                case 1: {
                                    for (Person person : personList) {
                                        person.showSickLeave();
                                        System.out.println();
                                    }
                                    break;
                                }

                                case 2: {
                                    for (Person person : personList) {
                                        person.showNumbersOfDaysOnSickkLeave();
                                    }
                                    break;
                                }

                                case 3: {
                                    for (Person person : personList) {
                                        person.showEmployeeWherePaysOffice();
                                    }
                                    break;
                                }

                                case 4: {
                                    for (Person person : personList) {
                                        person.showBasicInformation();
                                        System.out.println();
                                    }
                                }
                            }
                        }
                        continue;
                    }

                    case 5: {
                        continue;
                    }
                }

            }
            while (choice != 5);
        }
    }
}
