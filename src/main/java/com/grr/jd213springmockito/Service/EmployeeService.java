package com.grr.jd213springmockito.Service;

import com.grr.jd213springmockito.data.Employee;
import com.grr.jd213springmockito.exceptions.BadName400;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import com.grr.jd213springmockito.exceptions.ExistedEmployee;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    private HashMap<String, Employee> book = new HashMap<>(Map.of(
            "R G", new Employee("R", "G", 1, 13230d),
            "R G2", new Employee("R", "G2", 1, 999d),
            "R G3", new Employee("R", "G3", 1, 888d),
            "R G4", new Employee("R", "G4", 2, 55d),
            "R G5", new Employee("R", "G5", 3, 666d),
            "R G6", new Employee("R", "G6", 6, 555d)
    ));


    public String addEmployee(String firstName, String lastName) throws ExistedEmployee, BadName400 {
        boolean full = true;
        String result = new String();
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
        Employee e = new Employee(fn, ln, Integer.MAX_VALUE, Double.MAX_VALUE);
        if (book.containsKey(e.getFullName())) {
            throw new ExistedEmployee();
        } else {
            book.put(e.getFullName(), e);
            result = e.toString();
        }

        return result;
    }


    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = null;
        Employee e = new Employee(firstName, lastName, Integer.MAX_VALUE, Double.MAX_VALUE);
        if (book.containsKey(e.getFullName())) {
            book.remove(e.getFullName());
            result = e.toString();
        }


        if (result == null) {
            throw new EmployeeNotFound();
        }


        return result;
    }


    public String findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        String result = null;
        Employee e = new Employee(firstName, lastName, Integer.MAX_VALUE, Double.MAX_VALUE);
        if (book.containsKey(e.getFullName())) {
            result = e.toString();
        }


        if (result == null) {
            throw new EmployeeNotFound();
        }
        return result;
    }

    public String allEmployee() {
        String result = book.toString();
        return result;
    }

    public HashMap<String,Employee> allEmployeeMap(){
        return book;
    }



}
