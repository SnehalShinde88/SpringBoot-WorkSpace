package com.db.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Employee;
import com.db.model.EmployeeRepository;
import com.db.model.UserDetails;

@RestController
public class DBController {

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/addData")
	public String data(@RequestBody Integer employeeId) throws ParseException {
		Employee employee = new Employee();
		String dateString = "09/12/1995";
		String IDOB="09/09/2000";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dobf = new SimpleDateFormat("dd/MM/yyyy");
		Date dobDate = dobf.parse(dateString);

		employee.setDOB(dobDate);
		employee.setEmpDesignation("AI Specialist");
		employee.setEmpId(employeeId);
		employee.setEmpJoiningDate(new Date());
		employee.setEmpName("Harsh");
		employeeRepository.save(employee);
		return "saved";
	}

	@GetMapping("/getData")
	public void getData(@RequestBody int employeeId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println("get Called");
		Employee empData = employeeRepository.findById(employeeId).orElse(null);
		Date empJoiningDateDB = empData.getEmpJoiningDate();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter lFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String formattedDateTime = now.format(lFormatter);
		System.out.println("empJoiningDateDB :: " + empJoiningDateDB + " & formattedDateTime :: " + formattedDateTime);

		LocalDateTime startDateTime = LocalDateTime.parse(empData.getEmpJoiningDate().toString(), formatter);
		LocalDateTime endDateTime = LocalDateTime.parse(formattedDateTime, formatter);
		long minutesDifference = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
		System.out.println("minutesDifference :: " + minutesDifference);

	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDetails userDetails) {
		System.out.println("userDetails :: " +userDetails.getuId());
		return userDetails.toString();
	}
	
	@GetMapping("/docker")
	public String getDocker() {
		return "Welcome to Docker ! .. you have successfully deployed docker image..";
	}

}
