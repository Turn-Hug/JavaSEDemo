package demo01.junit;

import demo01.domain.Employee;
import demo01.service.NameListService;
import demo01.service.TeamException;
import org.junit.Test;

/**
 * @Description: 对service类的测试
 * @Author: Hequan
 * @Version:
 * @Date: 2022/4/25 16:42
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 10;

        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
