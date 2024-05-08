package com.alvi.employeemanager.controller;


import com.alvi.employeemanager.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@SpringBootApplication
@RestController
@RequestMapping("report")
public class ReportController {

//    @Autowired
//    private ReportService service;
//
//    @GetMapping("generate/{format}")
//    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
//        return  service.exportReport(format);
//    }
}
