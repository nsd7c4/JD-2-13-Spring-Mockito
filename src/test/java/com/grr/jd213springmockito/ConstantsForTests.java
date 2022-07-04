package com.grr.jd213springmockito;

import com.grr.jd213springmockito.data.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstantsForTests {
    public static final String FIRST_NAME_CORRECT = "Rashid";
    public static final String FIRST_NAME_LOWER = "rashid";
    public static final String FIRST_NAME_WITHNUMBERS = "rashid123";

    public static final String LAST_NAME_CORRECT = "Gafurov";
    public static final String LAST_NAME_LOWER = "gafurov";
    public static final String LAST_NAME_WITHNUMBERS = "gafurov123";

    public static final String CORRECT_EMPLOYEE = "Employee{firstName='Rashid', lastName='Gafurov', salary=500.0, department=1}";
    public static final String CORRECT_EMPLOYEE_MAX_SALARY_DEPARTMENT1 = "Employee{firstName='Rashid', lastName='Gafurov', salary=99999.0d, department=1}";
    public static final String CORRECT_EMPLOYEE_BOOK = "{Rashid Gafurov=Employee{firstName='Rashid', lastName='Gafurov', salary=500.0, department=1}}";

    public static final String NOT_EXISTED_FIRST_NAME = "NOT_EXISTED_FIRST_NAME";
    public static final String NOT_EXISTED_LAST_NAME = "NOT_EXISTED_LAST_NAME";

    public static final int DEPARTMENT1 = 1;
    public static final int DEPARTMENT2 = 2;
    public static final int DEPARTMENT3 = 3;
    public static final double SALARY500 = 500.0;
    public static final double MAX_SALARY = Double.MAX_VALUE;
    public static final double MIN_SALARY = 0.0d;

    public static String NAME_MAX_SALARY_DEPARTMENT_1 = "Rashid";
    public static String LAST_MAX_SALARY_DEPARTMENT_1 = "Gafurov";
    public static Employee DEPARTMENT1_MAX_SALARY_EMPLOYEE = new Employee(NAME_MAX_SALARY_DEPARTMENT_1, LAST_MAX_SALARY_DEPARTMENT_1, DEPARTMENT1, MAX_SALARY);

    public static String NAME_MAX_SALARY_DEPARTMENT_2 = "Alex";
    public static String LAST_MAX_SALARY_DEPARTMENT_2 = "Ryabkov";
    public static Employee DEPARTMENT2_MAX_SALARY_EMPLOYEE = new Employee(NAME_MAX_SALARY_DEPARTMENT_2, LAST_MAX_SALARY_DEPARTMENT_2, DEPARTMENT2, MAX_SALARY);

    public static String NAME_MIN_SALARY_DEPARTMENT_1 = "Vova";
    public static String LAST_MIN_SALARY_DEPARTMENT_1 = "Kostantinos";
    public static Employee DEPARTMENT1_MIN_SALARY_EMPLOYEE = new Employee(NAME_MIN_SALARY_DEPARTMENT_1, LAST_MIN_SALARY_DEPARTMENT_1, DEPARTMENT1, MIN_SALARY);

    public static String NAME_MIN_SALARY_DEPARTMENT_2 = "Fedor";
    public static String LAST_MIN_SALARY_DEPARTMENT_2 = "Gerasimos";
    public static Employee DEPARTMENT2_MIN_SALARY_EMPLOYEE = new Employee(NAME_MIN_SALARY_DEPARTMENT_2, LAST_MIN_SALARY_DEPARTMENT_2, DEPARTMENT2, MIN_SALARY);

    public static HashMap<String, Employee> MockBook = new HashMap<>(Map.of(
            NAME_MAX_SALARY_DEPARTMENT_1 + " " + NAME_MAX_SALARY_DEPARTMENT_1, DEPARTMENT1_MAX_SALARY_EMPLOYEE,
            NAME_MAX_SALARY_DEPARTMENT_2 + " " + NAME_MAX_SALARY_DEPARTMENT_2, DEPARTMENT2_MAX_SALARY_EMPLOYEE,
            NAME_MIN_SALARY_DEPARTMENT_1 + " " + NAME_MIN_SALARY_DEPARTMENT_1, DEPARTMENT1_MIN_SALARY_EMPLOYEE,
            NAME_MIN_SALARY_DEPARTMENT_2 + " " + NAME_MIN_SALARY_DEPARTMENT_2, DEPARTMENT2_MIN_SALARY_EMPLOYEE,
            "R2 G2", new Employee("R2", "G2", 1, 999d),
            "R3 G3", new Employee("R3", "G3", 1, 888d),
            "R4 G4", new Employee("R4", "G4", 2, 55d),
            "R5 G5", new Employee("R5", "G5", 3, 666d),
            "R6 G6", new Employee("R6", "G6", 6, 555d)
    ));

    public static String AllEmployeeInDepartment1 = MockBook.values().stream()
            .filter(employee -> employee.getDepartment() == 1)
            .collect(Collectors.toList())
            .toString();

    public static String AllEmployeeInDepartment2 = MockBook.values().stream()
            .filter(employee -> employee.getDepartment() == 2)
            .collect(Collectors.toList())
            .toString();

    public static String AllEmployeeInDepartment3 = MockBook.values().stream()
            .filter(employee -> employee.getDepartment() == 3)
            .collect(Collectors.toList())
            .toString();


}
