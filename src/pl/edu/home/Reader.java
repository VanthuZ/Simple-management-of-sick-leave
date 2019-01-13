package pl.edu.home;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Reader {
    Path file;

    public List<Company> readCompany(){
      file = Paths.get("CompanyDatabase.csv");
      List<Company> companyList = new ArrayList<>();
      List<String> lines;
      ArrayList<String> departmentList;

        try {
            lines = Files.readAllLines(file);
            for (String l : lines){
                String[] line = l.split(";");
                if(line.length >= 2){

                        String[] department = line[1].split(",");
                        departmentList = new ArrayList<>();
                        for (int i = 0; i < department.length; i++) {

                            departmentList.add(department[i].substring(department[i].lastIndexOf(";") + 1));
                        }
                        companyList.add(new Company(line[0], departmentList));

                }else if(line.length == 1){
                    companyList.add(new Company(line[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    public List<Person> readPerson(List<Company> companyList){
        file = Paths.get("PersonDatabase.csv");
        List<Person> personList = new ArrayList<>();
        List<String> lines;
        Map<String, Integer> map;

        try {
            lines = Files.readAllLines(file);
            for (String l : lines) {
                String[] oneLine = l.split(";");
                if (oneLine.length == 9) {
                    String[] sickLeaveDays = oneLine[8].split(",");
                    map = new HashMap<>();
                    for (int i = 0; i < sickLeaveDays.length; i += 2) {
                        map.put(sickLeaveDays[i], Integer.parseInt(sickLeaveDays[i + 1]));
                    }
                    personList.add(new Person(oneLine[0], oneLine[1], findCompany(oneLine[2], companyList), oneLine[4],
                            oneLine[5], oneLine[6].charAt(0), oneLine[7], map));
                }else{
                    personList.add(new Person(oneLine[0], oneLine[1], findCompany(oneLine[2], companyList), oneLine[4],
                            oneLine[5], oneLine[6].charAt(0), oneLine[7]));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public Company findCompany(String companyName, List<Company> companyList){
        Company company = null;
        for(Company c : companyList){
            if(c.getName().equals(companyName)){
                company = c;
            }
        }
        return company;
    }

}
