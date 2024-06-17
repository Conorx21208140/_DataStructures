public class Employee implements Comparable<Employee> {
    private int employeeID;
    private String name;
    private String department;

    // Constructor to initialize employee data
    public Employee(int employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }

    // Getters for employee attributes
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // Compare employees based on their employee ID (natural ordering)
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeID, other.employeeID);
    }

    // String representation of an employee for printing
    @Override
    public String toString() {
        return "EmployeeID: " + employeeID + ", Name: " + name + ", Department: " + department;
    }
}
