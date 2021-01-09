package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zensar.bean.Employee;
import com.zensar.utility.DBUtil;

public class EmployeeRepository{

public void addEmployee(Employee employee)
	{
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "insert into employee values(?,?,?,?,?,?)";
		try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, employee.getEmployeeId());
		pst.setString(2, employee.getEmployeeName());
		pst.setString(3, employee.getDesignation());
		pst.setInt(4, employee.getSalary());
		pst.setString(5, employee.getGender());
		pst.setString(6, employee.getCity());
		
		int result=pst.executeUpdate();
		if(result==0) {
			System.out.println("database opeartion failed");
		}
		else
		{
			System.out.println("database operation successful");
		}
		}catch(Exception e) {
			System.out.println("Exception Occured:"+e);
	}
	}
	public List<Employee> getAllEmployees(){
	List<Employee> listOfAllEmployees = new ArrayList<Employee>();
	// jdbc code to fetch all employees from db and add them to this list
	Connection con = DBUtil.getMySqlDbConnection();
	String sql = "select * from employee";
	try {
	PreparedStatement pst = con.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while(rs.next()) {
	int employeeId = rs.getInt("employee_id");
	String employeeName = rs.getString("employee_name");
	String designation = rs.getString("designation");
	int salary = rs.getInt("salary");
	String gender = rs.getString("gender");
	String city=rs.getString("city");
	Employee employee = new Employee(employeeId, employeeName, designation, salary, gender, city);
	listOfAllEmployees.add(employee);
	}
	}catch(Exception e) {
	System.out.println("Exception Occured:"+e);
	}
	System.out.println("listOfAllEmployees:"+listOfAllEmployees);
	return listOfAllEmployees;
	}
	
	
	public void deleteEmployee(int employeeId) {
		Connection con=DBUtil.getMySqlDbConnection();
		String sql="delete from employee where employee_id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, employeeId);
			int result=pst.executeUpdate();
			if(result==0) {
				System.out.println("deletion failed");
			}else {
				System.out.println("deletion success");
			}
		}catch(Exception e) {
			System.out.println("Exception occured:"+e);
		}
	}
	
	public Employee getEmployee(int employeeId) {
		Employee employee = null;
		// jdbc code to connect to database and fetch employee details with this id
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "select * from employee where employee_id=?";
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
		String employeeName = rs.getString("employee_name");
		String designation = rs.getString("designation");
		int salary = rs.getInt("salary");
		String gender = rs.getString("gender");
		String city = rs.getString("city");
		employee = new Employee(employeeId, employeeName, designation, salary, gender, city);
		}
		}catch(Exception e) {
		System.out.println("Exception Occured:"+e);
		}

		return employee;
		}
	
	public void updateEmployee(Employee employee) {
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "update employee set employee_name=?, designation=?, salary=?, gender=?, city=? where employee_id=?";
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, employee.getEmployeeName());
		pst.setString(2, employee.getDesignation());
		pst.setInt(3, employee.getSalary());
		pst.setString(4, employee.getGender());
		pst.setString(5, employee.getCity());
		pst.setInt(6, employee.getEmployeeId());
		pst.executeUpdate();

		}catch(Exception e) {
		System.out.println("Exception Occured:"+e);
		}
		}
	
	public boolean checkLogin(String user_name,String password) {
		boolean result = false;
		Connection con=DBUtil.getMySqlDbConnection();
		String sql="select * from login where user_name=?";
		try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, user_name);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			String passwordFromDb = rs.getString("password");
			if(password.equals(passwordFromDb)) {
				result = true;
			}
				
		}
	}catch(Exception e) {
		System.out.println("Exception occured :"+e);
	}
		return result;
}
}


	/*
	public Employee getEmployee(int employeeId) {
		Employee employee=null;
		
		// jdbc code to connect to database and fetch employee details with this id
		Connection con=DBUtil.getMySqlDbConnection();
		String sql="select * from employee where employee_id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, employeeId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
			String employeeName=rs.getString("employeeName");
			String designation=rs.getString("designation");
			int salary=rs.getInt("salary");
			String gender=rs.getString("gender");
			
			employee=new Employee(employeeId, employeeName, designation, salary, gender );
			}
			
		}catch(Exception e) {
			System.out.println("Exception occured:"+e);
		}
		
	
	return employee;
	}
	}
	*/
/*
public List<Employee> getAllEmployees(){
	List<Employee> listOfAllEmployees=new ArrayList<Employee>();
	//jdbc code to fetch all employees from db and add them to this list
	Connection con=DBUtil.getMySqlDbConnection();
	String sql="select * from employee";
	try {
	PreparedStatement pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	while(rs.next()){
		int employeeId=rs.getInt("employeeId");
		String employeeName=rs.getString("employeeName");
		String designation=rs.getString("designation");
		int salary=rs.getInt("salary");
		String gender=rs.getString("gender");
		Employee employee = new Employee(employeeId, employeeName, designation, salary, gender);
		listOfAllEmployees.add(employee);
		
	}
	}catch(Exception e) {
		System.out.println("exception occured :"+e);
	}
	return listOfAllEmployees;
}
}*/
