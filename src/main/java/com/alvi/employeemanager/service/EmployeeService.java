package com.alvi.employeemanager.service;

import com.alvi.employeemanager.exception.UserNotFoundException;
import com.alvi.employeemanager.model.Employee;
import com.alvi.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EmployeeService {
    private  final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }

    public  Employee updateEmployee(Employee employee){

        return  employeeRepo.save(employee);
    }

    public List<Employee>findAllEmployee(String reportFormat) throws FileNotFoundException, JRException {
        String path="F:\\Angular And SpringBoot\\report";

        List<Employee>employees=employeeRepo.findAll();

        File file= ResourceUtils.getFile("classpath:employee.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employees);
        Map<String,Object> parameter=new HashMap<>();
        parameter.put("createdBy","Alvir Walid");
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameter,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\employee.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"employee.pdf");
        }


        return  employees;
    }

    public  Employee findEmployeeById(Integer id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id: "+id+"was not found"));
    }

    @Transactional
    public  void deleteEmployeeById(Integer id){
        employeeRepo.deleteEmployeeById(id);
    }
}
