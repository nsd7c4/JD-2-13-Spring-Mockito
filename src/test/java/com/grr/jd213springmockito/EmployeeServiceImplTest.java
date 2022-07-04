package com.grr.jd213springmockito;

import com.grr.jd213springmockito.Service.EmployeeServiceImpl;
import com.grr.jd213springmockito.exceptions.BadName400;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import com.grr.jd213springmockito.exceptions.ExistedEmployee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.grr.jd213springmockito.ConstantsForTests.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnCorrectNameWhenAdding() throws BadName400, ExistedEmployee {
        String result = out.addEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT, DEPARTMENT1, SALARY500);
        Assertions.assertEquals(CORRECT_EMPLOYEE, result);
    }

    @Test
    public void shouldReturnCorrectNameWhenAddingWithLowerName() throws BadName400, ExistedEmployee {
        String result = out.addEmployee(FIRST_NAME_LOWER, LAST_NAME_LOWER, DEPARTMENT1, SALARY500);
        Assertions.assertEquals(CORRECT_EMPLOYEE, result);
    }

    @Test
    public void shouldReturnExceptionWhenAddingWithNonAlphaName() {
        Assertions.assertThrows(BadName400.class, () -> out.addEmployee(FIRST_NAME_WITHNUMBERS, LAST_NAME_WITHNUMBERS, DEPARTMENT1, SALARY500));
    }


    @Test
    public void shouldReturnCorrectEmployeeWhenRemoving() throws EmployeeNotFound, BadName400, ExistedEmployee {
        out.addEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT, DEPARTMENT1, SALARY500);
        String result = out.removeEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT);
        Assertions.assertEquals(CORRECT_EMPLOYEE, result);
    }

    @Test
    public void shouldReturnEmployeeNotFoundWhenRemovingNotExistedEmployee() {
        Assertions.assertThrows(EmployeeNotFound.class, () -> out.removeEmployee(NOT_EXISTED_FIRST_NAME, NOT_EXISTED_LAST_NAME));
    }

    @Test
    public void shouldReturnCorrectEmployeeWhenFindning() throws EmployeeNotFound, BadName400, ExistedEmployee {
        out.addEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT, DEPARTMENT1, SALARY500);
        String result = out.findEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT);
        Assertions.assertEquals(CORRECT_EMPLOYEE, result);
    }

    @Test
    public void shouldReturnEmployeeNotFoundWhenFindingNotExistedEmployee() {
        Assertions.assertThrows(EmployeeNotFound.class, () -> out.removeEmployee(NOT_EXISTED_FIRST_NAME, NOT_EXISTED_LAST_NAME));
    }

    @Test
    public void shouldReturnAllEmployee() throws BadName400, ExistedEmployee {
        out.addEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT, DEPARTMENT1, SALARY500);
        String result = out.allEmployee();
        Assertions.assertEquals(CORRECT_EMPLOYEE_BOOK, result);
    }

    @Test
    public void shouldReturnBOOK() throws BadName400, ExistedEmployee {
        out.addEmployee(FIRST_NAME_CORRECT, LAST_NAME_CORRECT, DEPARTMENT1, SALARY500);
        String result = out.allEmployee();
        Assertions.assertEquals(CORRECT_EMPLOYEE_BOOK, result);
    }


}
