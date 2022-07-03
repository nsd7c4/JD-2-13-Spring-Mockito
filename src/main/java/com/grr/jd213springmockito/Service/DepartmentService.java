package com.grr.jd213springmockito.Service;

import com.grr.jd213springmockito.data.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String maxSalaryByDepartment(int departmentID) {
        final Employee streamMax = employeeService.allEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment()==departmentID)
                .max((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .orElseThrow();
        return  streamMax.toString();
    }

    public String minSalaryByDepartment(int departmentID) {
        final Employee streamMax = employeeService.allEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment()==departmentID)
                .min((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .orElseThrow();
        return  streamMax.toString();
    }

    public String allByDepartment(int departmentID) {
        final List<Employee> streamAll= employeeService.allEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment()==departmentID)
                .collect(Collectors.toList());
        return streamAll.toString();
    }
}
