public class Main {
    public static void main(String[] args) {
        // Create a BST to manage employee data
        BST bst = new BST();

        // Add employees to the BST
        bst.insert(new Employee(1234, "John Doe", "Development"));
        bst.insert(new Employee(5678, "Jane Smith", "HR"));
        bst.insert(new Employee(3456, "Alice Brown", "Sales"));
        bst.insert(new Employee(2345, "Bob White", "Finance"));
        bst.insert(new Employee(7890, "Chris Green", "Development"));

        // Search for an employee by their employee ID
        Employee foundEmployee = bst.search(3456);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee from the BST based on their employee ID
        bst.delete(3456);
        System.out.println("Employee with ID 3456 has been deleted.");

        // Print all employee records in numerical order of their employee ID
        System.out.println("All employee records in BST:");
        bst.printAll();
    }
}
