package main.java.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeParser {
	private List<Employee> employees;

	public EmployeeParser() {
		employees = new ArrayList<>();
	}

	public void parseFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			//System.out.println("Parse file called");
			Employee currentEmployee = null;
			String line;
			String key = null;

			while ((line = br.readLine()) != null) {
				int indentLevel = getIndentLevel(line);
				String trimmedLine = line.trim();

				if (trimmedLine.isEmpty()) {
					continue; // Ignore empty lines
				}

				if (indentLevel == 1) {
					// key attribute (ID, Name, Salary)
					// add a new employee only when indent value has a ID associated with it
					//System.out.println("Index 1 :"+trimmedLine);
					key = trimmedLine;
					if(key.equals("ID")) {
						// 
						currentEmployee = new Employee();
						employees.add(currentEmployee);
					}
				} else if (indentLevel == 2 && currentEmployee != null && key != null) {
					//System.out.println("Index 2 :"+trimmedLine);
					// Attribute value
					setAttributeValue(currentEmployee, key, trimmedLine);
					key = null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getIndentLevel(String line) {
		int indentLevel = 0;
		while (line.startsWith(" ")) {
			indentLevel++;
			line = line.substring(1);
		}
		//System.out.println("Line : "+line +" Indent level :"+ indentLevel);
		return indentLevel;
	}

	private void setAttributeValue(Employee employee, String attribute, String value) {
		//System.out.println("Attribute received "+employee);
		switch (attribute) {
		case "ID":
			try {
				int id = Integer.parseInt(value);
				employee.setID(id);
			} catch (NumberFormatException e) {
				System.err.println("Invalid ID value: " + value);
			}
			break;
			
		case "Name":
			employee.setName(value);
			break;
			
		case "Salary":
			try {
				int salary = Integer.parseInt(value);
				employee.setSalary(salary);
			} catch (NumberFormatException e) {
				System.err.println("Invalid Salary value: " + value);
			}
			break;
			
		default:
			// Invalid attribute in the input file. Ignore or handle as needed.
			break;
		}
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
