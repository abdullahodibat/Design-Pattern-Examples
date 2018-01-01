import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class Composite {

    public static void main(String[] args) {
        Employee ceo = new Employee("Me", 1000);
        Employee technologyDiretor = new Employee("john", 600);
        Employee marketingDirector = new Employee("sara", 600);
        Employee marketer = new Employee("hans", 500);
        Employee developer = new Employee("david", 500);
        ceo.addTeamMember(technologyDiretor);
        ceo.addTeamMember(marketingDirector);
        marketingDirector.addTeamMember(marketer);
        technologyDiretor.addTeamMember(developer);

        System.out.println(ceo);
        for (Employee i : ceo.team) {
            System.out.println(i);
            for (Employee j : i.team) {
                System.out.println(j);
            }
        }
    }

    static class Employee {
        String name;
        int salary;
        List<Employee> team;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
            team = new ArrayList<>();
        }

        public void addTeamMember(Employee employee) {
            this.team.add(employee);
        }

        @Override
        public String toString() {
            return "name: " + this.name + ", salary: " + salary;
        }
    }

}
