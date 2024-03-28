package com.gds.ey.employee.serial;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class EmployeeView {
	
private Scanner scanner = new Scanner(System.in);
List <Employees> employees;
//private int empCount=5;
	
	{
		
		
	Employees emp1 = new Employees(1, "Akhila",LocalDate.of(2000, 5, 16),EmployeeType.CEO);
	Employees emp2 = new Employees(2, "Raveendran",LocalDate.of(1994, 7, 23),EmployeeType.MANAGER);
	Employees emp3 = new Employees(3, "Anu",LocalDate.of(1990, 11, 1),EmployeeType.DEVELOPER);
	Employees emp4 = new Employees(4, "Hari",LocalDate.of(2001, 9, 26),EmployeeType.CTO);
	Employees emp5 = new Employees(5, "Manu",LocalDate.of(1984, 1, 5),EmployeeType.DEVELOPER);
	
	employees = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4, emp5));
	
	Consumer<Employees> consumer = new Consumer<Employees>() {

		@Override
		public void accept(Employees t) {
			System.out.println(t);			
		}
	};
	
	Consumer<Employees> consumer1 = t-> System.out.println(t);
	employees.forEach(consumer);
	employees.forEach(consumer1);
	
		
	}


	public EmployeeView() throws IOException, ClassNotFoundException {
		System.out.println("EmployeeView Management System");
		
		employeeDeserialization();

		while(true) {
		selectOption();
		}
	}
	
	private void selectOption() throws IOException {
		
		
		
		System.out.println("Please select an option from below");
		System.out.println("1. Add Employee");
		System.out.println("2. Display Employee");
		System.out.println("3. Display Employee with id");
		System.out.println("4. Delete Employee with id");
		System.out.println("5. Update with id");
		System.out.println("6. Display Employee by Type");
		System.out.println("7. Display Employee greater than age: ");
		System.out.println("8. Exit Application");
		int option = scanner.nextInt();
		
		
		switch(option) {
		
		case 1:{
			addEmployees();
			return;
		}
		case 2:{
			displayEmployees();
			return;
			
		}
		case 3:{

			displayEmployeeById();
			return;
		}
		case 4:{

			deleteEmployeeById();
			return;
		
		}
		case 5:{
			updateEmployee();
			return;
		}
		case 6:{
			displayEmployeeByType();
			return;
		}
		case 7:{
			displayEmployeeByAge();
			return;
		}
		case 8:{
			employeeSerialization();
			System.err.println("...Application Ended...");
			System.err.println("...Thank You for using Application...");
			System.exit(0);
		}
		default:{
			System.out.println("Please enter correct option");
			
		}
		}
		
	}
	
	
	private void addEmployees() {
		boolean ans = true;
		do {
		System.out.println("Enter Employee id: ");
		int id = scanner.nextInt();
		
		
		try {
			//boolean exist=false;
			for(Employees emp : employees) {
				if(id == emp.getId()) {
					//System.out.println("Sorry Employee Id already exist...");
					//exist = true;
					throw new EmployeeIdAlreadyExistException("The Employee Id entered is already exist in data");
				}
			}
				
				//if(!exist) {
					System.out.println("Enter Employee Name: ");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter Employee Date of Birth in the format dd/MM/yyyy");
					String dateOfBirth = scanner.nextLine();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate date = LocalDate.parse(dateOfBirth, formatter);
					
					System.out.println("Enter Employee Type: CEO/CTO/DEVELOPER/MANAGER ");
//					scanner.nextLine();
					String type = scanner.nextLine();
					
					EmployeeType enumType = EmployeeType.valueOf(type);
					
					
					
					Employees employee1 = new Employees(id,name,date,enumType);
				
					employees.add(employee1);
					//employees[empCount] = employee;
					//empCount++;
					System.out.println("Employee added");
					
				//}
		}
		catch(EmployeeIdAlreadyExistException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		
				
			
		
		
		System.out.println("Do you want to continue adding employee: y/n? ");
		String ansInput = scanner.next();
		
		
		if(!ansInput.equalsIgnoreCase("y")) {
			ans = false;
		}
		}while(ans);
		System.out.println("=============================================");
		return;
		
	}
	
	private void displayEmployees() {//Variablea argument
		System.out.println("============================");
		
		for(Employees emp : employees) {
			
			System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDateOfBirth()+" : "+Period.between(emp.getDateOfBirth(),LocalDate.now()).getYears()+" : "+emp.getEmployeeType());
			
		
		}
		System.out.println("============================");
	}
	
	private void displayEmployeeById() {
		System.out.println("Enter employee id");
		int empId = scanner.nextInt();
		
		Employees findEmployee = null;
		for(Employees emp: employees) {
			if(emp.getId() == empId) {
				
				findEmployee = emp;
				break;
				
			}
		}
		
		if(findEmployee != null) {
			System.out.println(findEmployee.getId()+" "+ findEmployee.getName()+"  "+findEmployee.getDateOfBirth()+" "+Period.between(findEmployee.getDateOfBirth(),LocalDate.now()).getYears()+" "+findEmployee.getEmployeeType());
		}else {
			System.out.println("Employee with id "+empId+" does not exist");
		}
		System.out.println("=============================================");
		return;
		
	}
	
	private void deleteEmployeeById() {
		
		System.out.println("Enter employee id");
		int empId = scanner.nextInt();
		
		for(Employees emp: employees) {
			
			if(emp.getId() == empId) {
				
				employees.remove(emp);
				//empCount--;
				break;
			}
		}
		for(Employees emp: employees) {
			System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDateOfBirth()+" : "+Period.between(emp.getDateOfBirth(),LocalDate.now()).getYears()+" : "+emp.getEmployeeType());
		}
		
		return;
		
		
	}

	

	private void updateEmployee() {
		System.out.println("Enter employee id");
		int empId = scanner.nextInt();
		
		Employees findEmployee = null;
		for(Employees emp : employees) {
			if(empId == emp.getId()) {
				
				findEmployee = emp;
				break;
			}
		}
				//System.out.println("Sorry Employee Id already exist...");
				
		
			
			if(findEmployee != null) {
				
				
				System.out.println("Enter Employee Name: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Enter Employee Date of Birth in format dd/MM/yyyy ");
				String dateOfBirth = scanner.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateOfBirth, formatter);
				
//				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
//				Date date1 = format.parse(dateOfBirth);
				
				System.out.println("Enter Employee Type: CEO/CTO/DEVELOPER/MANAGER ");
//				scanner.nextLine();
				String type = scanner.nextLine();
				
				EmployeeType enumType = EmployeeType.valueOf(type);
				
				findEmployee.setName(name);
				findEmployee.setDateOfBirth(date);
				findEmployee.setEmployeeType(enumType);
				System.out.println("Employee with id "+empId+" is updated");
				
				
			}
			
			return;
	}
//		if(empId>empCount) {
//			System.out.println("Employee does not exist");
//		}
		
	



	private void displayEmployeeByType() {
		System.out.println("Enter employee Type as CEO/CTO/MANAGER/DEVELOPER");
		scanner.nextLine();
		String empType = scanner.nextLine();
		
		
		for(Employees emp: employees) {
//			
			if(emp.getEmployeeType().toString().equals(empType)) {
				System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDateOfBirth()+" : "+Period.between(emp.getDateOfBirth(),LocalDate.now()).getYears()+" : "+emp.getEmployeeType());
			}
		}
		
		System.out.println("=============================================");
		
	}
	
	private void displayEmployeeByAge() {
		
		System.out.println("Enter the Age");
		scanner.nextLine();
		int empAge = scanner.nextInt();
		
		
		
		
		for(Employees emp: employees) {
			
		
				Period period = Period.between(emp.getDateOfBirth(),LocalDate.now());
				int year = period.getYears(); 
				
				if(year > empAge) {
					
					System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDateOfBirth()+" : "+Period.between(emp.getDateOfBirth(),LocalDate.now()).getYears()+" : "+emp.getEmployeeType());
				
				
			}
		}
		
		
		
		
	}
	private void employeeSerialization() throws IOException {
		File file = new File("employeebasket.txt");
		try(FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			oos.writeObject(employees);
			System.out.println("Employee data added to Employee-Basket");
		}
	}
	
	private void employeeDeserialization() throws IOException, ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream("employeebasket.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			Object object = ois.readObject();
			 employees = (List<Employees>)object;
	}

}
}
