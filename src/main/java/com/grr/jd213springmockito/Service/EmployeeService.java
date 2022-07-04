package com.grr.jd213springmockito.Service;

import com.grr.jd213springmockito.data.Employee;
import com.grr.jd213springmockito.exceptions.BadName400;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import com.grr.jd213springmockito.exceptions.ExistedEmployee;

import java.util.HashMap;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName, int department, double salary) throws ExistedEmployee, BadName400;
    String removeEmployee(String firstName, String lastName) throws EmployeeNotFound;
    String findEmployee(String firstName, String lastName) throws EmployeeNotFound;
    String allEmployee();
    HashMap<String, Employee> getBook();
}
