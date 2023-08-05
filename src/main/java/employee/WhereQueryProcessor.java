package main.java.employee;

import java.util.ArrayList;
import java.util.List;

public class WhereQueryProcessor {
    private List<Employee> employees;

    public WhereQueryProcessor(List<Employee> employees) {
        this.employees = employees;
    }
    
    public List<Employee> queryByID(int id, String operator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (evaluateExpression(employee.getID(), id, operator)) {
                result.add(employee);
            }
        }
        
        for(Employee emp : result) {
        	System.out.println(emp.getID());
        }
        return result;
    }

    public List<Employee> queryBySalary(int salary, String operator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (evaluateExpression(employee.getSalary(), salary, operator)) {
                result.add(employee);
            }
        }
        for(Employee emp : result) {
        	System.out.println(emp.getSalary());
        }
        return result;
    }

    public List<Employee> queryByName(String name, String operator) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (evaluateExpression(employee.getName(), name, operator)) {
                result.add(employee);
            }
        }
        for(Employee emp : result) {
        	System.out.println(emp.getName());
        }
        return result;
    }

    private boolean evaluateExpression(int a, int b, String operator) {
        switch (operator) {
            case ">":
                return a > b;
            case ">=":
                return a >= b;
            case "<":
                return a < b;
            case "<=":
                return a <= b;
            case "=":
                return a == b;
            case "!=":
                return a != b;
            default:
                return false;
        }
    }

    private boolean evaluateExpression(String a, String b, String operator) {
        switch (operator) {
            case "=":
                return a.equals(b);
            case "!=":
                return !a.equals(b);
            default:
                return false;
        }
    }

}