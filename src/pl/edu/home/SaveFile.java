package pl.edu.home;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class SaveFile {
    FileWriter fileWriter;
    PrintWriter printWriter;


    public void savePerson(List<Person> personList){
        int i;
        try {

            fileWriter = new FileWriter("PersonDatabase.csv");
            printWriter = new PrintWriter(fileWriter);

                for(Person person : personList){
                    printWriter.print(person.getName() + ";" + person.getLastName() + ";" + person.getCompany().getName()
                            + ";" + person.getCompany().getDepartment() + ";" + person.getPeriodOfEmployment() + ";" +
                            person.getEmploymentState() + ";" + person.getEmployeeOrStudent() + ";" +
                            person.getDayOfRealease() + ";");
                    i = 0;
                    for(Map.Entry<String, Integer> entry : person.getSickLeaveDateAndDays().entrySet()){

                        if(++i == person.getSickLeaveDateAndDays().size()) {
                            printWriter.print(entry.getKey() + "," + entry.getValue() + ";");
                        }else{
                            printWriter.print(entry.getKey() + "," + entry.getValue() + ",");
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
        int i;
        try {
            fileWriter = new FileWriter("CompanyDatabase.csv");
            printWriter = new PrintWriter(fileWriter);

            for(Company company : companyList){
                printWriter.print(company.getName() + ";" );
                i = 0;
                for(String department : company.getDepartmentList()){
                    if(++i == company.getDepartmentList().size()) {
                        // last iteration
                        printWriter.print(department + ";");
                    }else if(company.getDepartmentList().size() != 0){
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
