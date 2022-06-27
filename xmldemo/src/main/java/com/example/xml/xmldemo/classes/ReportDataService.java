package com.example.xml.xmldemo.classes;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportDataService {

    public boolean marshal() throws Exception{
        ReportData reportData = new ReportData();
        List<ReportData.TextRow> textRows = new ArrayList<>();
        ReportData.TextRow textRow = new ReportData.TextRow();
        textRow.setRowNumber("1");
        textRow.setId("CAMC20543");
        textRow.setName("ACADEMY MORTGAGE CORPORATION - 20543");
        ReportData.TextRow.Invoice invoice = new ReportData.TextRow.Invoice();
        invoice.setRecordNo("MER-00146914");
        invoice.setCustvendId("CAMC20543");
        invoice.setDocno("MER-00146914");
        invoice.setWhenCreated("04/30/2022");
        invoice.setTotal("11.25");
        invoice.setTotalDue("11.25");
        invoice.setTotalPaid("0");
        invoice.setPrrecordKey("356052");
        invoice.setPaymentStatus("Posted");
        invoice.setDescription("");
        invoice.setWhenDue("05/31/2022");
        invoice.setTransType("Invoice");
        invoice.setCustomerName("ACADEMY MORTGAGE CORPORATION - 20543");
        invoice.setSalesInvoiceBatch("MCL-04-30-2022");
        textRow.setInvoice(invoice);
        ReportData.TextRow.SubTotal subTotal = new ReportData.TextRow.SubTotal();
        subTotal.setName("ACADEMY MORTGAGE CORPORATION - 20543");
        subTotal.setId("CAMC20543");
        subTotal.setTotal("11.25");
        textRow.setSubTotal(subTotal);
        // setting second text row
        ReportData.TextRow textRow1 = new ReportData.TextRow();
        textRow1.setRowNumber("2");
        textRow1.setId("C10043505");
        textRow1.setName("SUMMIT MORTGAGE LLC");
        ReportData.TextRow.Invoice invoice1 = new ReportData.TextRow.Invoice();
        invoice1.setRecordNo("MER-00144061");
        invoice1.setCustvendId("C10043505");
        invoice1.setDocno("MER-00144061");
        invoice1.setWhenCreated("04/30/2022");
        invoice1.setTotal("1672.4");
        invoice1.setTotalDue("1672.4");
        invoice1.setTotalPaid("0");
        invoice1.setPrrecordKey("350919");
        invoice1.setPaymentStatus("Posted");
        invoice1.setDescription("");
        invoice1.setWhenDue("05/31/2022");
        invoice1.setTransType("Invoice");
        invoice1.setCustomerName("SUMMIT MORTGAGE LLC");
        invoice1.setSalesInvoiceBatch("MCL-04-30-2022");
        textRow1.setInvoice(invoice1);
        ReportData.TextRow.SubTotal subTotal1 = new ReportData.TextRow.SubTotal();
        subTotal1.setName("SUMMIT MORTGAGE LLC");
        subTotal1.setId("C10043505");
        subTotal1.setTotal("1672.4");
        textRow1.setSubTotal(subTotal1);

        // setting second third row
        ReportData.TextRow textRow2 = new ReportData.TextRow();
        textRow2.setRowNumber("3");
        textRow2.setId("C10044305-LIOR.M");
        textRow2.setName("MINNTRUST MORTGAGE");
        ReportData.TextRow.Invoice invoice2 = new ReportData.TextRow.Invoice();
        invoice2.setRecordNo("MER-00144255");
        invoice2.setCustvendId("C10044305-LIOR.M");
        invoice2.setDocno("MER-00144255");
        invoice2.setWhenCreated("04/30/2022");
        invoice2.setTotal("403.9");
        invoice2.setTotalDue("403.9");
        invoice2.setTotalPaid("0");
        invoice2.setPrrecordKey("351290");
        invoice2.setPaymentStatus("Posted");
        invoice2.setDescription("");
        invoice2.setWhenDue("05/31/2022");
        invoice2.setTransType("Invoice");
        invoice2.setCustomerName("MINNTRUST MORTGAGE");
        invoice2.setSalesInvoiceBatch("MCL-04-30-2022");
        textRow2.setInvoice(invoice2);
        ReportData.TextRow.SubTotal subTotal2 = new ReportData.TextRow.SubTotal();
        subTotal2.setName("MINNTRUST MORTGAGE");
        subTotal2.setId("C10044305-LIOR.M");
        subTotal2.setTotal("1403.9");
        textRow2.setSubTotal(subTotal2);

        textRows.add(textRow);
        textRows.add(textRow1);
        textRows.add(textRow2);
        reportData.setTextRow(textRows);

        JAXBContext context = JAXBContext.newInstance(ReportData.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(reportData, new File("D:/report-data.xml"));
        System.out.println("done");
        return true;
    }

    public ReportData unmarshall() throws Exception{
        JAXBContext context = JAXBContext.newInstance(ReportData.class);
        return (ReportData) context.createUnmarshaller()
                .unmarshal(new FileReader("D:/report-data.xml"));
    }
}
