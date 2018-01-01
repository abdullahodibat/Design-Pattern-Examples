import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class Filter {

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 35));
        employees.add(new Employee("jack", 25));

        Criteria byAge = new AgeCriteria();

        List<Employee> filteredByAge = byAge.filter(employees);
        for (Employee e: filteredByAge){
            System.out.println(e.name);
        }
    }

    static class Employee {
        int age;
        String name;

        public Employee(String name, int age) {
            this.age = age;
            this.name = name;
        }
    }

    interface Criteria {
        List<Employee> filter(List<Employee> employees);
    }

    static class AgeCriteria implements Criteria {

        @Override
        public List<Employee> filter(List<Employee> employees) {
            List<Employee> filteredEmployees = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.age > 30) filteredEmployees.add(employee);
            }
            return filteredEmployees;
        }
    }
}
