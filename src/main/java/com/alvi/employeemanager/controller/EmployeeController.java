package com.alvi.employeemanager.controller;

import com.alvi.employeemanager.model.Employee;
import com.alvi.employeemanager.service.EmployeeService;
import com.alvi.employeemanager.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private  final EmployeeService employeeService;
    private ReportService service;


    //    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all/{format}")
    public ResponseEntity<List<Employee>>getEmployees(@PathVariable String format) throws FileNotFoundException, JRException {

        System.out.println(format+"= fffffffffffffff");

        List<Employee>employees=employeeService.findAllEmployee(format);
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public  ResponseEntity<Employee>getEmployeeById(@PathVariable("id") Integer id){
        Employee employee = employeeService.findEmployeeById(id);
        return new  ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee =employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?>deleteEmployee(@PathVariable("id")Integer id){
        employeeService.deleteEmployeeById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("generate/{format}")
//    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
//        return  service.exportReport(format);
//    }
}
