package EmployeeMVC.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/test")
	public void test(HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("hello World");
	}
}
