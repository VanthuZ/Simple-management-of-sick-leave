package pl.edu.home;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class SaveFile {
    FileWriter fileWriter;
    PrintWriter printWriter;
    int i;

    public void savePerson(List<Person> personList){
        try {

            fileWriter = new FileWriter("PersonDatabase.csv");
            printWriter = new PrintWriter(fileWriter);
            i = 0;
                for(Person person : personList){
                    printWriter.print(person.getName() + ";" + person.getLastName() + ";" + person.getCompany().getName()
                            + ";" + person.getCompany().getDepartment() + ";" + person.getPeriodOfEmployment() + ";" +
                            person.getEmploymentState() + ";" + person.getEmployeeOrStudent() + ";" +
                            person.getDayOfRealease() + ";" + person.getWhoPayForSickLeave() + ";");

                    for(Map.Entry<String, Integer> entry : person.getSickLeaveDateAndDays().entrySet()){
                        if(i++ != person.getSickLeaveDateAndDays().size()) {
                            printWriter.print(entry.getKey() + "," + entry.getValue() + ";");
                        }else if(i++ == person.getSickLeaveDateAndDays().size()){
                            printWriter.print(entry.getKey() + "," + entry.getValue() + ";");
                        }

                    }
                    printWriter.println();
                }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveCompany(List<Company> companyList){
        try {
            fileWriter = new FileWriter("CompanyDatabase.csv");
            printWriter = new PrintWriter(fileWriter);
            i = 0;
            for(Company company : companyList){
                printWriter.print(company.getName() + ";" );

                for(String department : company.getDepartmentList()){
                    if(++i == company.getDepartmentList().size()) {
                        // last iteration
                        printWriter.print(department + ";");
                    }else{
                        printWriter.print(department + ",");
                    }

                }
                printWriter.println();
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
