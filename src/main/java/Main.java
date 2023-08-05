package main.java;

import java.util.List;
import java.util.Scanner;

import main.java.employee.Employee;
import main.java.employee.EmployeeParser;
import main.java.employee.WhereQueryProcessor;

public class Main {
	public static void main(String[] args) {
		// Parse the input file and get the list of employees
		EmployeeParser employeeParser = new EmployeeParser();
		String filePath = "resource/input.txt";

		employeeParser.parseFile(filePath);
		List<Employee> employees = employeeParser.getEmployees();
		
		WhereQueryProcessor obj = new WhereQueryProcessor(employees);

		for(Employee emp : employees) {
			System.out.println(emp.getID()+" "+emp.getName()+ " "+emp.getSalary());
		}
		Scanner str = new Scanner(System.in); 
		System.out.println("Enter query");

		String query = str.nextLine();  

		if(query.contains("where")){
			String[] tokens = query.split("where");
			if (tokens[1]!=null) {
				//System.out.println(tokens[1]);
				
				String[] splittedToken = tokens[1].split(" ");
				
				String column = splittedToken[1];
		        String value = splittedToken[3];

		        String operator = splittedToken[2];
		        
				switch (column) {
				case "ID":
			        int id =Integer.parseInt(value);  
					obj.queryByID(id, operator);
					break;
				case "Name":
					obj.queryByName(value, operator);
					break;
				case "Salary":
			        int salary =Integer.parseInt(value);  
					obj.queryBySalary(salary, operator);
				default:
					break;
				}
		        
			}
			else {
				System.err.println("Data not found!!!");
			}
		}



	}


}
