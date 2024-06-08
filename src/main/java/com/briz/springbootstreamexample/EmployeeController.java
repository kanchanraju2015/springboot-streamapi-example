package com.briz.springbootstreamexample;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "This  is stream test";
}
@RequestMapping("/save")
public Employee save()
{
	Employee e=new Employee();
	e.setAge(90);
	e.setCity("bokaro");
	e.setName("chanchal");
	return erepo.save(e);
}
@RequestMapping("/all")
public List<Employee> allemp()
{
	List<Employee> employees=erepo.findAll();
	return employees.stream().map(emp->emp).collect(Collectors.toList());	
}
@RequestMapping("/names")
public List<String> names()
{
	List<Employee> employees=erepo.findAll();
	List<String> names=employees.stream().map(emp->emp.getName()).collect(Collectors.toList());
	return names;
}
}
