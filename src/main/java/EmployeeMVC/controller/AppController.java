package EmployeeMVC.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import EmployeeMVC.dao.EmployeeDao;
import EmployeeMVC.dto.Employee;

@Controller
public class AppController {
	
	@Autowired
	EmployeeDao edao;
	
	@RequestMapping("/test")
	public void test(HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("hello World");
	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp() {
		ModelAndView view =new ModelAndView();
		view.addObject("emp",new Employee());
		view.setViewName("signup.jsp");
		return view;
	}
	
	public ModelAndView saveEmp(@ModelAttribute Employee emp) {
		edao.saveEmployee(emp);
		ModelAndView view =new ModelAndView();
		view.setViewName("login.jsp");
		return view;
	}
}
