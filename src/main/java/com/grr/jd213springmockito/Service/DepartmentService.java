package com.grr.jd213springmockito.Service;

import com.grr.jd213springmockito.data.Employee;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public String maxSalaryByDepartment(int departmentID) throws EmployeeNotFound {
//        final Optional<Employee> streamMax;
//        streamMax = Optional.ofNullable(employeeService.getBook().values().stream()
//                .filter(employee -> employee.getDepartment() == departmentID)
//                .max(Comparator.comparingDouble(Employee::getSalary))
//                        .orElseThrow(EmployeeNotFound::new));
//        return  streamMax.toString();
        final Optional<Employee> streamMax = Optional.of(employeeService.getBook().values().stream()
                .filter(employee -> employee.getDepartment() == departmentID)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get());
        return streamMax.get().toString();
    }

    public String minSalaryByDepartment(int departmentID) throws EmployeeNotFound {
//        final Optional<Employee> streamMin = Optional.of(employeeService.getBook().values().stream()
//                .filter(employee -> employee.getDepartment() == departmentID)
//                .min(Comparator.comparingDouble(Employee::getSalary))
//                .orElseThrow(EmployeeNotFound::new));

        final Optional<Employee> streamMin = Optional.of(employeeService.getBook().values().stream()
                .filter(employee -> employee.getDepartment() == departmentID)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get());
        return streamMin.get().toString();
    }

    public String allByDepartment(int departmentID) {
        final List<Employee> streamAll= employeeService.getBook().values().stream()
                .filter(employee -> employee.getDepartment()==departmentID)
                .collect(Collectors.toList());
        return streamAll.toString();
    }
}
