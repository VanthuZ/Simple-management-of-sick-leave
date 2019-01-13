package pl.edu.home;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    Path file;
    Scanner scanner;

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
}
