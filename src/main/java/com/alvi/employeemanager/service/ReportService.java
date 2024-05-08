package com.alvi.employeemanager.service;


import com.alvi.employeemanager.model.Employee;
import com.alvi.employeemanager.repo.EmployeeRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class ReportService {

//    private EmployeeRepo repository;
//    private  EmployeeService employeeService;
//
//    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
//        String path="F:\\Angular And SpringBoot\\report";
//        List<Employee> userList=employeeService.findAllEmployee(reportFormat);
//
//
//        //Load file and compile it
//        File file= ResourceUtils.getFile("classpath:employee.jrxml");
//        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(userList);
//         Map<String,Object> parameter=new HashMap<>();
//         parameter.put("createdBy","Alvir Walid");
//        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameter,dataSource);
//        if(reportFormat.equalsIgnoreCase("html")){
//            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\employee.html");
//        }
//        if(reportFormat.equalsIgnoreCase("pdf")){
//            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"employee.pdf");
//        }
//        return "Report generated in path"+path;
//    }
}
