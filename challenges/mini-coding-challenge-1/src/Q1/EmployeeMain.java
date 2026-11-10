package Q1;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Nimal", 45000),
                new Employee("Sunil", 75000),
                new Employee("Kamal", 30000)
        );

        employees.forEach(employee -> {
            if(employee.salary < 50000){
                employee.salary += 5000;
            }
            System.out.println(employee.name + " - "+  employee.salary);
        });





    }
}
