package com.mastery.java.task.rest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! Zapp";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeDao.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws EmployeeNotFoundException {
        Employee employee = employeeDao.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee( @RequestBody Employee employee) {
        return this.employeeDao.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
        Employee employee = employeeDao.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setGender(employeeDetails.getGender());
        return ResponseEntity.ok(this.employeeDao.save(employee));
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws EmployeeNotFoundException {
        Employee employee = employeeDao.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        this.employeeDao.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}