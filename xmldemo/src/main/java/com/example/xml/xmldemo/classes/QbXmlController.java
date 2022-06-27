package com.example.xml.xmldemo.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QbXmlController {

    @Autowired
    QbXmlService service;

    @GetMapping("/qb/marshal")
    public boolean marshal() throws Exception{
        return service.marshal();
    }

    /*@GetMapping("/unmarshal")
    public ReportData unmarshal() throws Exception{
        ReportData unmarshal = service.unmarshall();
        System.out.println(unmarshal);
        return unmarshal;
    }*/
}
