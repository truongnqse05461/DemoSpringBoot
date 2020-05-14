package com.example.demo001.controller;

import com.example.demo001.model.Employee;
import com.example.demo001.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public String index(Model model) {
		model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", new Employee());
		return "list";
	}

	@GetMapping("/employee/create")
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		return "form";
	}

	@GetMapping("/employee/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "form";
	}

	@PostMapping("/employee/save")
	public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		employeeService.save(employee);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/employee";
	}

	@GetMapping("/employee/{id}/delete")
	public String delete(@PathVariable long id, RedirectAttributes redirect) {
		Employee emp = employeeService.findOne(id);
		employeeService.delete(emp);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/employee";
	}

	@GetMapping("/employee/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/employee";
		}

		model.addAttribute("employees", employeeService.search(s));
		return "list";
	}
}
