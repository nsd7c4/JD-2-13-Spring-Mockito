package com.grr.jd213springmockito.Service;

import com.grr.jd213springmockito.data.Employee;
import com.grr.jd213springmockito.exceptions.BadName400;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import com.grr.jd213springmockito.exceptions.ExistedEmployee;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


@Service
@Repository
public class EmployeeServiceImpl implements EmployeeService{
    private final HashMap<String, Employee> book;

    public EmployeeServiceImpl() {
        book = new HashMap<>(Map.of(
//                "R G", new Employee("R", "G", 1, 13230d),
//                "R G2", new Employee("R", "G2", 1, 999d),
//                "R G3", new Employee("R", "G3", 1, 888d),
//                "R G4", new Employee("R", "G4", 2, 55d),
//                "R G5", new Employee("R", "G5", 3, 666d),
//                "R G6", new Employee("R", "G6", 6, 555d)
        ));
    }


    public String addEmployee(String firstName, String lastName, int department, double salary) throws ExistedEmployee, BadName400 {
        String fullName = firstName+ " " +lastName;
        String result;
        String fn = firstName;
        String ln = lastName;
        fn = StringUtils.trim(fn);
        ln = StringUtils.trim(ln);
        fn = StringUtils.lowerCase(fn);
        ln = StringUtils.lowerCase(ln);
        fn = StringUtils.capitalize(fn);
        ln = StringUtils.capitalize(ln);


        if (!StringUtils.isAlpha(fn) || !StringUtils.isAlpha(ln)) {
            throw  new BadName400();
        }
        Employee e = new Employee(fn, ln, department, salary);
        if (book.containsKey(fullName)) {
            throw new ExistedEmployee();
        } else {
            book.put(fullName, e);
            result = e.toString();
        }

        return result;
    }


    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = null;
        String fullName = firstName + " " + lastName;
        if (book.containsKey(fullName)) {
            result = book.get(fullName).toString();
            book.remove(fullName);
        }

        if (result == null) {
            throw new EmployeeNotFound();
        }

        return result;
    }


    public String findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = null;
        String fullName = firstName + " " + lastName;
        if (book.containsKey(fullName)) {
            result = book.get(fullName).toString();
        }

        if (result == null) {
            throw new EmployeeNotFound();
        }

        return result;
    }

    public String allEmployee() {
        return book.toString();
    }

    public HashMap<String,Employee> getBook(){
        return book;
    }



}
