package com.example.xml.xmldemo.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReportDataController {

    @Autowired
    ReportDataService service;

    @GetMapping("/marshal")
    public boolean marshal() throws Exception{
        return service.marshal();
    }

    @GetMapping("/unmarshal")
    public ReportData unmarshal() throws Exception{
        ReportData unmarshal = service.unmarshall();
        System.out.println(unmarshal);
        return unmarshal;
    }
}
