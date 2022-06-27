package com.example.xml.xmldemo.classes;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QbXmlService {
    public boolean marshal() throws Exception{
        QbXml qbXml = new QbXml();
        QbXml.QbXmlMsgsRs qbXmlMsgsRs= new QbXml.QbXmlMsgsRs();
        var generalDetailReportQueryRs = new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs();
        generalDetailReportQueryRs.setStatusCode("0");
        generalDetailReportQueryRs.setStatusSeverity("Info");
        generalDetailReportQueryRs.setStatusMessage("Status OK");
        var reportRet = new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet();
        reportRet.setReportTitle("Open Invoices");
        reportRet.setReportSubtitle("As of April 5, 2010");
        reportRet.setReportBasis("Accrual");
        reportRet.setNumRows("7558");
        reportRet.setNumColumns("9");
        reportRet.setNumColTitleRows("1");
        List<QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc> colDescList = new ArrayList<>();
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("1","STRTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1"),"Blank"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("2","STRTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","Type"),"TxnType"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("3","DATETYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","Date"),"Date"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("4","STRTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","Num"),"RefNumber"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("5","STRTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","P. O. #"),"PONumber"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("7","DATETYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","Due Date"),"DueDate"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("8","INTTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","Aging"),"Aging"));
        colDescList.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc("9","AMTTYPE",new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ColDesc.ColTitle("1","OpenBalance"),"Open Balance"));
        reportRet.setColDesc(colDescList);
        var reportData = new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal();
        var rows = new ArrayList<QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.Row>();
        rows.add(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.TextRow("1","10037/AMERICAN ACCEPTANCE MORTGAGE, INC"));
        var dataRow = new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow("2");
        dataRow.setRowData(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.RowData("name", "10037/AMERICAN ACCEPTANCE MORTGAGE, INC"));
        dataRow.setColData(Arrays.asList(
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("2","Invoice"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("3","2010-02-28"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("4","93150"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("6","Due on receipt"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("7","2010-02-28"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("8","36"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("9","1954.95")
        ));
        rows.add(dataRow);
        var subTotalRow = new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.SubtotalRow("3");
        subTotalRow.setRowData(new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.RowData("name", "10037/AMERICAN ACCEPTANCE MORTGAGE, INC"));
        subTotalRow.setColData(Arrays.asList(
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("1","Total 10037/AMERICAN ACCEPTANCE MORTGAGE, INC"),
                new QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow.ColData("9","4066.40")
        ));
        rows.add(subTotalRow);
        reportData.setDataRow(rows.stream().filter(row -> row instanceof QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow).map(row -> (QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.DataRow)row).collect(Collectors.toList()));
        reportData.setTextRow(rows.stream().filter(row -> row instanceof QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.TextRow).map(row -> (QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.TextRow)row).collect(Collectors.toList()));
        reportData.setSubtotalRow(rows.stream().filter(row -> row instanceof QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.SubtotalRow).map(row -> (QbXml.QbXmlMsgsRs.GeneralDetailReportQueryRs.ReportRet.ReportDataLocal.SubtotalRow)row).collect(Collectors.toList()));
        reportRet.setReportData(reportData);
        generalDetailReportQueryRs.setReportRet(reportRet);
        qbXmlMsgsRs.setGeneralDetailReportQueryRs(generalDetailReportQueryRs);
        qbXml.setQbXmlMsgsRs(qbXmlMsgsRs);

        JAXBContext context = JAXBContext.newInstance(QbXml.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(qbXml, new File("D:/qbXml-data.xml"));
        System.out.println("done");
        return true;
    }

}
