public class BST {
    private BSTNode root;

    // Constructor to initialize an empty BST
    public BST() {
        root = null;
    }

    // Method to insert a new employee into the BST
    public void insert(Employee employee) {
        root = insertRecursive(root, employee);
    }

    // Recursive helper method for insertion
    private BSTNode insertRecursive(BSTNode node, Employee employee) {
        if (node == null) {
            return new BSTNode(employee);
        }

        if (employee.compareTo(node.employee) < 0) {
            node.left = insertRecursive(node.left, employee);
        } else if (employee.compareTo(node.employee) > 0) {
            node.right = insertRecursive(node.right, employee);
        }

        return node;
    }

    // Method to search for an employee by their employee ID
    public Employee search(int employeeID) {
        return searchRecursive(root, employeeID);
    }

    // Recursive helper method for searching
    private Employee searchRecursive(BSTNode node, int employeeID) {
        if (node == null) {
            return null; // Employee not found
        }

        if (employeeID == node.employee.getEmployeeID()) {
            return node.employee;
        } else if (employeeID < node.employee.getEmployeeID()) {
            return searchRecursive(node.left, employeeID);
        } else {
            return searchRecursive(node.right, employeeID);
        }
    }

    // Method to delete an employee from the BST based on their employee ID
    public void delete(int employeeID) {
        root = deleteRecursive(root, employeeID);
    }

    // Recursive helper method for deletion
    private BSTNode deleteRecursive(BSTNode node, int employeeID) {
        if (node == null) {
            return null; // Employee not found
        }

        if (employeeID < node.employee.getEmployeeID()) {
            node.left = deleteRecursive(node.left, employeeID);
        } else if (employeeID > node.employee.getEmployeeID()) {
            node.right = deleteRecursive(node.right, employeeID);
        } else {
            // Employee found, now delete the node
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node has two children, find the minimum value in the right subtree
            node.employee = findMin(node.right).employee;
            // Delete the minimum node from the right subtree
            node.right = deleteRecursive(node.right, node.employee.getEmployeeID());
        }

        return node;
    }

    // Helper method to find the minimum node in a BST
    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Method to print all employee records in numerical order of their employee ID
    public void printAll() {
        printInOrder(root);
    }

    // Recursive helper method for in-order traversal
    private void printInOrder(BSTNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.employee);
            printInOrder(node.right);
        }
    }
}
