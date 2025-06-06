import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {

    // Component
    static interface Employee {
        void showEmployeeDetails();
    }

    // Leaf
    static class Developer implements Employee {
        private final String name;
        private final long empId;
        private final String position;

        public Developer(long empId, String name, String position) {
            this.empId = empId;
            this.name = name;
            this.position = position;
        }

        @Override
        public void showEmployeeDetails() {
            System.out.println(empId + " - " + name + " [" + position + "]");
        }
    }

    // Leaf
    static class Manager implements Employee {
        private final String name;
        private final long empId;
        private final String department;

        public Manager(long empId, String name, String department) {
            this.empId = empId;
            this.name = name;
            this.department = department;
        }

        @Override
        public void showEmployeeDetails() {
            System.out.println(empId + " - " + name + " [Manager, " + department + "]");
        }
    }

    // Composite
    static class CompanyDirectory implements Employee {
        private final List<Employee> employeeList = new ArrayList<>();

        public void addEmployee(Employee emp) {
            employeeList.add(emp);
        }

        public void removeEmployee(Employee emp) {
            employeeList.remove(emp);
        }

        @Override
        public void showEmployeeDetails() {
            for (Employee emp : employeeList) {
                emp.showEmployeeDetails();
            }
        }
    }


    public static void main(String[] args) {
        Developer dev1 = new Developer(100, "Alice", "Frontend Developer");
        Developer dev2 = new Developer(101, "Bob", "Backend Developer");

        Manager manager1 = new Manager(200, "Charlie", "IT");

        CompanyDirectory developerDirectory = new CompanyDirectory();
        developerDirectory.addEmployee(dev1);
        developerDirectory.addEmployee(dev2);

        CompanyDirectory managerDirectory = new CompanyDirectory();
        managerDirectory.addEmployee(manager1);

        CompanyDirectory company = new CompanyDirectory();
        company.addEmployee(developerDirectory);
        company.addEmployee(managerDirectory);

        System.out.println("Company Employees:");
        company.showEmployeeDetails();
    }
}
