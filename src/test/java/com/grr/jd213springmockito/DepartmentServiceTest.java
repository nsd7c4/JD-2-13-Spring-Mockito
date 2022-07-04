package com.grr.jd213springmockito;

import com.grr.jd213springmockito.Service.DepartmentService;
import com.grr.jd213springmockito.Service.EmployeeServiceImpl;
import com.grr.jd213springmockito.exceptions.EmployeeNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.grr.jd213springmockito.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl EmployeeServiceMock;

    @InjectMocks
    private DepartmentService out;

    @Test
    public void shouldReturnEmployeeWithMaxSalaryInDepartment() throws EmployeeNotFound {
        assertEquals(DEPARTMENT1_MAX_SALARY_EMPLOYEE.toString(), out.maxSalaryByDepartment(DEPARTMENT1));
        assertEquals(DEPARTMENT2_MAX_SALARY_EMPLOYEE.toString(), out.maxSalaryByDepartment(DEPARTMENT2));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryInDepartment() throws EmployeeNotFound {
        assertEquals(DEPARTMENT1_MIN_SALARY_EMPLOYEE.toString(), out.minSalaryByDepartment(DEPARTMENT1));
        assertEquals(DEPARTMENT2_MIN_SALARY_EMPLOYEE.toString(), out.minSalaryByDepartment(DEPARTMENT2));
    }

    @Test
    public void shouldReturnAllEmployeeInDepartment() throws EmployeeNotFound {
        assertEquals(AllEmployeeInDepartment1,out.allByDepartment(DEPARTMENT1));
        assertEquals(AllEmployeeInDepartment2,out.allByDepartment(DEPARTMENT2));
        assertEquals(AllEmployeeInDepartment3,out.allByDepartment(DEPARTMENT3));
    }

    @BeforeEach
    public void addMockBook() {
        when(EmployeeServiceMock.getBook())
                .thenReturn(MockBook);
    }
}
