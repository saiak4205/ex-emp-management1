package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee>employeeList = service.showList();
		model.addAttribute("employeeList",employeeList);
		return "employee/list.html";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		int employeeId = Integer.parseInt(id);
		model.addAttribute("employee",service.showDetail(employeeId));
		return "employee/detail.html";
	}
	
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		int employeeId = Integer.parseInt(form.getId());
		Employee employee = service.showDetail(employeeId);
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		service.update(employee);
		return "redirect:showList";
	}

}
