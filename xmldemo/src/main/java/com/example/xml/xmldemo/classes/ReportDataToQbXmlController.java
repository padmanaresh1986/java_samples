package com.example.xml.xmldemo.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportDataToQbXmlController {

    @Autowired
    ReportDataToQbXmlService service;

    @GetMapping("/convert")
    public boolean convert() throws Exception{
        service.convert();
        return true;
    }
}
