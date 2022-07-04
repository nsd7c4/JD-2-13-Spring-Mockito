package com.grr.jd213springmockito.Controller;

import com.grr.jd213springmockito.Service.DepartmentService;
import com.grr.jd213springmockito.Service.EmployeeServiceImpl;
import com.grr.jd213springmockito.exceptions.BadName400;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import com.grr.jd213springmockito.exceptions.ExistedEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeServiceImpl employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("first") String firstName,
                              @RequestParam("last") String lastName,
                              @RequestParam("department") int department,
                              @RequestParam("salary") double salary) throws ExistedEmployee, BadName400 {
        return employeeService.addEmployee(firstName, lastName,department,salary);
    }

    @GetMapping(path = "/employee/remove")
    public String removeEmployee(@RequestParam("first") String firstName, @RequestParam("last") String lastName) throws EmployeeNotFound {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/employee/find")
    public String findEmployee(@RequestParam("first") String firstName, @RequestParam("last") String lastName) throws EmployeeNotFound {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/employee/all")
    public String allEmployee() {
        return employeeService.allEmployee();
    }

    @GetMapping(path = "/departments/max-salary")
    public String maxSalaryByDepartmentn(@RequestParam("departmentId") Integer departmentID) throws EmployeeNotFound {
        return departmentService.maxSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/departments/min-salary")
    public String minSalaryByDepartmentn(@RequestParam("departmentId") Integer departmentID) throws EmployeeNotFound {
        return departmentService.minSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/departments/all")
    public String allByDepartmentn(@RequestParam(value = "departmentId", required = false) Integer departmentID) {
        if (departmentID == null) {
            return employeeService.allEmployee();
        } else {
            return departmentService.allByDepartment(departmentID);
        }
    }

}
