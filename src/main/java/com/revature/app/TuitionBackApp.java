package com.revature.app;

import com.revature.service.*;
import com.revature.trms.*;
import com.revature.data.*;
import io.javalin.Javalin;

public class TuitionBackApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javalin app = Javalin.create();
		app.start(8080);
		
		app.get("/request", ctx ->{
			System.out.println("Hello world!");
			ctx.result("It works!");
		});
		
		app.post("/post", ctx ->{
			System.out.println("This is a post!");
			ctx.result("The post works!");
		});
		
		app.get("/get", ctx ->{
			System.out.println("This is a get!");
			ctx.result("The get works!");
		});
		
//		app.get("/Department", ctx ->{
//			ServiceImp serv = new ServiceImp(new EmployeesDAOImpl());
//			ctx.json(serv.viewDepartmentNames());
//		});
//		
//		app.post("/Employees", ctx->{
//			Employees employee = ctx.bodyAsClass(Employees.class);
//			System.out.println(employee);
////			EmployeesDAO employeeDAO = DAOConnect.getEmployeesDAO();
//		});
//		
//		app.post("/Managers", ctx ->{
//			Managers manager = ctx.bodyAsClass(Managers.class);
//			System.out.println(manager);
//		});
		}

}
